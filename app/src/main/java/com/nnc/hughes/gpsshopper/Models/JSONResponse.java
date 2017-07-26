package com.nnc.hughes.gpsshopper.Models;

/**
 * Created by marcus on 7/26/17.
 */

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class JSONResponse {
        private Roster[] roster;

        public Roster[] getRoster() {
            return roster;
        }

}