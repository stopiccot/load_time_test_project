using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class TestScript : MonoBehaviour {

	// Use this for initialization
	void Start () {
		
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
