            package com.example.myapplication

            import android.annotation.SuppressLint
            import android.os.Bundle
            import android.os.Handler
            import android.os.Looper
            import android.view.View
            import android.webkit.WebView
            import android.webkit.WebViewClient
            import androidx.appcompat.app.AppCompatActivity

            class MainActivity : AppCompatActivity() {
                private lateinit var webView: WebView

                @SuppressLint("SetJavaScriptEnabled")
                override fun onCreate(savedInstanceState: Bundle?) {
                    super.onCreate(savedInstanceState)
                    setContentView(R.layout.activity_main)

                    webView = findViewById(R.id.webView)
                    val settings = webView.settings
                    settings.javaScriptEnabled = true
                    settings.domStorageEnabled = true
                    settings.builtInZoomControls = true
                    settings.displayZoomControls = false
                    settings.allowFileAccess = true

                    webView.webViewClient = WebViewClient()
                    webView.loadUrl("file:///android_asset/index.html")

                    val splashView = findViewById<View>(R.id.splashView)
if (splashView != null) {
    Handler(Looper.getMainLooper()).postDelayed({
        splashView.animate().alpha(0f).setDuration(400).withEndAction {
            splashView.visibility = View.GONE
        }.start()
    }, 1200)
}
                }

                override fun onBackPressed() {
                    if (webView.canGoBack()) {
                        webView.goBack()
                    } else {
                        super.onBackPressed()
                    }
                }
            }