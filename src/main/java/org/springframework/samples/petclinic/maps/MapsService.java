package org.springframework.samples.petclinic.maps;

import com.google.maps.*;
import com.google.maps.model.*;

public class MapsService {

    public static LatLng getLatLng(String address) throws Exception {
        GeoApiContext context = new GeoApiContext.Builder()
            .apiKey("AIzaSyBMa3HETtRs85Zopw9xlMf7D72aan9qsro")
            .build();
        GeocodingResult[] results = GeocodingApi.geocode(context, address).await();
        if (results.length > 0) {
            return results[0].geometry.location;
        } else {
            return null;
        }
    }
    
}

