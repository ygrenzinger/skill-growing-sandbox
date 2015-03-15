package com.carbon.skillsgrowing.front.web.api;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.jar.Attributes;
import java.util.jar.Manifest;

@Controller
@RequestMapping("/admin/version")
public class AdminVersion {

    private static final Logger log = LoggerFactory.getLogger(AdminVersion.class);
    public static final String MANIFEST_PATH = "/META-INF/MANIFEST.MF";

    public AdminVersion() {
    }

    @RequestMapping(value = "/", method = RequestMethod.GET, produces = {"application/json"})
    public ResponseEntity<Map<String, String>> getVersions(HttpServletRequest request){
        ServletContext context = request.getSession().getServletContext();
        InputStream manifestStream = context.getResourceAsStream(MANIFEST_PATH);
        Manifest manifest = null;
        try {
            manifest = new Manifest(manifestStream);
        } catch (IOException e) {
            log.error("Failed to load manifest in {}", MANIFEST_PATH, e);
            throw new RuntimeException("Failed to load manifest", e);
        }finally {
            try {
                manifestStream.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        Map<String, String> response = manifestToMap(manifest.getEntries());
        response.putAll(manifestAttributesToMap(manifest.getMainAttributes()));

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    private Map<String, String> manifestToMap(Map<String, Attributes> entries) {
        Map<String, String> response = new HashMap<>();

        for (Map.Entry<String, Attributes> attributesEntry : entries.entrySet()) {
            response.put(attributesEntry.getKey(), attributesEntry.getValue().toString());
            response.putAll(manifestAttributesToMap(attributesEntry.getValue()));
        }

        return response;
    }

    private Map<String, String> manifestAttributesToMap(Attributes attributes) {
        Map<String, String> response = new HashMap<>();

        for (Map.Entry<Object, Object> entry : attributes.entrySet()) {
            response.put(entry.getKey().toString(), entry.getValue().toString());
        }

        return response;
    }
}
