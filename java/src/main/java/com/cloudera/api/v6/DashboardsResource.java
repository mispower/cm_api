// Licensed to Cloudera, Inc. under one
// or more contributor license agreements.  See the NOTICE file
// distributed with this work for additional information
// regarding copyright ownership.  Cloudera, Inc. licenses this file
// to you under the Apache License, Version 2.0 (the
// "License"); you may not use this file except in compliance
// with the License.  You may obtain a copy of the License at
//
//     http://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing, software
// distributed under the License is distributed on an "AS IS" BASIS,
// WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// See the License for the specific language governing permissions and
// limitations under the License.
package com.cloudera.api.v6;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.cloudera.api.model.ApiDashboard;
import com.cloudera.api.model.ApiDashboardList;

@Produces({MediaType.APPLICATION_JSON})
@Consumes({MediaType.APPLICATION_JSON})
public interface DashboardsResource {

  /**
   * Returns the list of all user-customized dashboards. This includes both the
   * new dashboards created by users as well as any user customizations to
   * built-in dashboards.
   * <p>
   * Available since API v6.
   */
  @GET
  @Path("/")
  public ApiDashboardList getDashboards();

  /**
   * Creates the list of dashboards. If any of the dashboards already exist
   * this whole command will fail and no dashboards will be created.
   * <p>
   * Available since API v6.
   * @param list The list of dashboards to create.
   * @return The dashboards created.
   */
  @POST
  @Path("/")
  public ApiDashboardList createDashboards(ApiDashboardList list);

  /**
   * Returns a dashboard definition for the specified name. This dashboard
   * can be imported with the createDashboards API.
   * <p>
   * Available since API v6.
   * @param dashboardName The name of the dashboard.
   */
  @GET
  @Path("/{dashboardName}")
  public ApiDashboard getDashboard(
      @PathParam("dashboardName") String dashboardName);

  /**
   * Deletes a dashboard.
   *
   * <p>
   * Available since API v6.
   * @param dashboardName The name of the dashboard.
   * @return The deleted dashboard.
   */
  @DELETE
  @Path("/{dashboardName}")
  public ApiDashboard deleteDashboard(
      @PathParam("dashboardName") String dashboardName);
}
