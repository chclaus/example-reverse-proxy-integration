/*
 * Copyright 2016, Christian Claus
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package de.chclaus.examples;

import org.mitre.dsmiley.httpproxy.ProxyServlet;
import org.springframework.boot.context.embedded.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Christian Claus (c.claus@micromata.de)
 */
@Configuration
public class ElasticsearchServletConfiguration {

  @Bean(name = "elasticsarchServlet")
  public ServletRegistrationBean elasticsearchServletRegistrationBean() {
    ProxyServlet proxyServlet = new ProxyServlet();

    ServletRegistrationBean servletRegistrationBean = new ServletRegistrationBean(proxyServlet);
    servletRegistrationBean.setName("elasticsearch");

    servletRegistrationBean.setUrlMappings(new ArrayList<>(Arrays.asList("/elasticsearch/*")));

    Map<String, String> initParams = new HashMap<>();
    initParams.put("targetUri", "http://localhost:9200");
    servletRegistrationBean.setInitParameters(initParams);

    return servletRegistrationBean;
  }
}
