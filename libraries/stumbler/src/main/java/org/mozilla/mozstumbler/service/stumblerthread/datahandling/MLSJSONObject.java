/* This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/. */

package org.mozilla.mozstumbler.service.stumblerthread.datahandling;

import org.json.JSONArray;
import org.json.JSONObject;

/*
 This subclass of JSONObject provides additional getters - and only getters for convenient access
 to bits of data that are relevant to the Ichnaea JSON specification.
 */
public class MLSJSONObject extends JSONObject {

    public int radioCount() {
        int result = 0;
        result += getWifiCount();
        result += getCellCount();
        return result;
    }

    public int getWifiCount() {
        JSONArray wifiRecords = this.optJSONArray(DataStorageConstants.ReportsColumns.WIFI);
        return (wifiRecords == null ? 0 : wifiRecords.length());
    }

    public int getCellCount() {
        JSONArray cellRecords = this.optJSONArray(DataStorageConstants.ReportsColumns.CELL);
        return (cellRecords == null ? 0 : cellRecords.length());
    }

}
