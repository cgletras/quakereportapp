package com.example.quakereport;

import android.content.Context;
import android.util.Log;

import androidx.test.platform.app.InstrumentationRegistry;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import com.example.quakereport.classes.Earthquake;
import com.example.quakereport.utils.QueryUtils;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.ArrayList;

import static org.junit.Assert.*;

/**
 * Instrumented test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class ExampleInstrumentedTest {
    @Test
    public void useAppContext() {
        // Context of the app under test.
        Context appContext = InstrumentationRegistry.getInstrumentation().getTargetContext();
        assertEquals("com.example.quakereport", appContext.getPackageName());

        ArrayList<Earthquake> earthquakes = QueryUtils.extractEarthquakes();
        for(int i=0; i < earthquakes.size(); i++){
            Log.i("teste","Magnitude: "+earthquakes.get(i).getMag()+", Location: "+earthquakes.get(i).getPlace()+", Time: "+earthquakes.get(i).getTime());
        }
    }
}