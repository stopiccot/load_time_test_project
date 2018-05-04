using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class TestScript : MonoBehaviour {

    public UnityEngine.UI.Text text;

    // Use this for initialization
    void Start() {
        long time = 0;

#if UNITY_ANDROID
        using (AndroidJavaClass loadTimeUnityPlayerActivityClass = new AndroidJavaClass("com.tripledot.LoadTimeUnityPlayerActivity")) {
            time = loadTimeUnityPlayerActivityClass.CallStatic<long>("timeSinceOnCreate");
        }
#endif

        text.text = time.ToString();
    }
	
	// Update is called once per frame
	void Update () {
		
	}

    public void ButtonClick() 
    {
        var rt = GetComponent<RectTransform>();
        var ap = rt.anchoredPosition;
        ap.y += 20;
        rt.anchoredPosition = ap;
    }
}
