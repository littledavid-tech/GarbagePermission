package cn.shycoder.garbagepermissionapp

import android.Manifest
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import cn.shycoder.garbagepermissionlibrary.callbacks.OnPermissionRequestListener
import cn.shycoder.garbagepermissionlibrary.callbacks.SimpleOnPermissionRequestListener
import cn.shycoder.gargabepermissionlibrary.GarbagePermission

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun onClick(view: View) {
        GarbagePermission
                .with(this)
                .permissions(arrayOf(
                        Manifest.permission.READ_EXTERNAL_STORAGE,
                        Manifest.permission.WRITE_EXTERNAL_STORAGE,
                        Manifest.permission.CALL_PHONE))
                .callback(object : OnPermissionRequestListener {
                    override fun onGranted(permission: String) {
                        Log.e("TAG", "Granted")
                    }

                    override fun onDenied(permission: String) {
                        Log.e("TAG", "Denied")
                    }

                    override fun onRationale(permission: String) {
                        Log.e("TAG", "Rationale")
                    }
                })
                .request()

//
//        GarbagePermission
//                .with(this)
//                .permissions(arrayOf(Manifest.permission.READ_EXTERNAL_STORAGE))
//                .callback(object : SimpleOnPermissionRequestListener() {
//                    override fun onGranted(permission: String) {
//                        Log.e("TAG", "Granted")
//                    }
//                })
//                .request()
    }
}
