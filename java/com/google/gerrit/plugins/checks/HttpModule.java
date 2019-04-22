// Copyright (C) 2019 The Android Open Source Project
//
// Licensed under the Apache License, Version 2.0 (the "License");
// you may not use this file except in compliance with the License.
// You may obtain a copy of the License at
//
// http://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing, software
// distributed under the License is distributed on an "AS IS" BASIS,
// WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// See the License for the specific language governing permissions and
// limitations under the License.

package com.google.gerrit.plugins.checks;

import com.google.gerrit.extensions.registration.DynamicSet;
import com.google.gerrit.extensions.webui.JavaScriptPlugin;
import com.google.gerrit.extensions.webui.WebUiPlugin;
import com.google.gerrit.plugins.checks.api.CheckersRestApiServlet;
import com.google.gerrit.plugins.checks.api.PendingChecksRestApiServlet;
import com.google.inject.servlet.ServletModule;

public class HttpModule extends ServletModule {

  @Override
  protected void configureServlets() {
    serveRegex("^/checkers/(.*)$").with(CheckersRestApiServlet.class);
    serveRegex("^/checks.pending/(.*)$").with(PendingChecksRestApiServlet.class);

    DynamicSet.bind(binder(), WebUiPlugin.class).toInstance(new JavaScriptPlugin("checks-pg.html"));
  }
}
