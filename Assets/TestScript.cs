using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class TestScript : MonoBehaviour {

    public UnityEngine.UI.Text text;

    // Use this for initialization
    void Timestamp(string tag) {
        long time = 0;

#if UNITY_ANDROID && !UNITY_EDITOR
        using (AndroidJavaClass startupTimeApplicationClass = new AndroidJavaClass("com.tripledot.StartupTimeApplication")) {
            time = startupTimeApplicationClass.CallStatic<long>("timeSinceOnCreate", tag);
        }
#endif

        text.text = text.text + time.ToString() + " - " + tag + "\n";
    }

	private void Start() {
        Timestamp("Start");
        Firebase.Analytics.FirebaseAnalytics.LogEvent("event1");
        Timestamp("Event1");
        Firebase.Analytics.FirebaseAnalytics.LogEvent("event2");
        Timestamp("Event2");
	}

	public void ButtonClick() 
    {
        var rt = GetComponent<RectTransform>();
        var ap = rt.anchoredPosition;
        ap.y += 20;
        rt.anchoredPosition = ap;
    }
}
