/*
 * Copyright 2010 Luke Daley
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
package grails.plugins.remotecontrol

import grails.plugins.Plugin
import org.apache.commons.logging.LogFactory
import org.springframework.boot.web.servlet.ServletRegistrationBean

class RemoteControlGrailsPlugin extends Plugin {

    private static LOG = LogFactory.getLog(this)

    def grailsVersion = "3.1.4 > *"
    def pluginExcludes = [
            "grails-app/**/*",
    ]

    def title = "Grails Remote Control" // Headline display name of the plugin
    def author = "Luke Daley"
    def authorEmail = "ld@ldaley.com"
    def description = '''\
Remotely control a Grails application (for functional testing)
'''
    def profiles = ['web']
    def documentation = "http://grails.org/plugin/remote-control"
    def license = "APACHE"

    def developers = [[name: "Luke Daley", email: "ld@ldaley.com"],
                      [name: "Puneet Behl", email: "puneet.behl007@gmail.com"]
    ]

    def issueManagement = [system: "GitHub", url: "https://github.com/alkemist/grails-remote-control/issues"]
    def scm = [url: "https://github.com/alkemist/grails-remote-control/issues/"]

    Closure doWithSpring() {
        { ->
            'grails-remote-control'(ServletRegistrationBean, new RemoteControlServlet(), "/${RemoteControl.RECEIVER_PATH}") {
                name = 'grails-remote-control'
                loadOnStartup = 1
            }
        }
    }
}
