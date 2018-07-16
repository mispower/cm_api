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

package com.cloudera.api.model;

import com.fasterxml.jackson.annotation.JsonCreator;

/**
 * The CDH version of the cluster.
 */
@Deprecated
public enum ApiClusterVersion {
  /** CDH3 version. CDH3 is not supported as of CM 5.0. */
  @Deprecated
  CDH3,
  /** CDH3u4x version. CDH3u4x is not supported as of CM 5.0. */
  @Deprecated
  CDH3u4X,
  /** CDH4 version */
  CDH4,
  /** CDH5 version */
  CDH5,
  /** CDH6 version */
  CDH6,
  /** Unknown version. */
  UNKNOWN;

  @JsonCreator
  public static ApiClusterVersion fromString(String version) {
    try {
      return ApiClusterVersion.valueOf(version);
    } catch (IllegalArgumentException iae) {
      return UNKNOWN;
    }
  }

}
