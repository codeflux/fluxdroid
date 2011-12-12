/*
 * Copyright 2011 CodeFlux, Inc <info@teamcodeflux.com>
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.teamcodeflux.android;

import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.http.converter.json.MappingJacksonHttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

public final class RestTemplateFactory {
    private static RestTemplate restTemplate;

    private RestTemplateFactory() throws Exception {
        throw new IllegalAccessException();
    }

    public static RestTemplate getRestTemplate() {
        if (RestTemplateFactory.restTemplate != null) {
            return restTemplate;
        }

        return createRestTemplate();
    }

    private static RestTemplate createRestTemplate() {
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.setMessageConverters(messageConverters());

        return restTemplate;
    }

    private static List<HttpMessageConverter<?>> messageConverters() {
        List<HttpMessageConverter<?>> messageConverters = new ArrayList<HttpMessageConverter<?>>();
        messageConverters.add(new MappingJacksonHttpMessageConverter());
        messageConverters.add(new StringHttpMessageConverter());

        return messageConverters;
    }

    public static void setRestTemplate(RestTemplate restTemplate) {
        RestTemplateFactory.restTemplate = restTemplate;
    }
}
