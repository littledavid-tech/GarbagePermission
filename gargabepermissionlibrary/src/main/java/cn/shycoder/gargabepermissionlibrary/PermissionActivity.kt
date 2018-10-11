package cn.shycoder.gargabepermissionlibrary

import android.annotation.TargetApi
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.drawable.ColorDrawable
import android.os.Build
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.Window
import cn.shycoder.garbagepermissionlibrary.callbacks.OnPermissionRequestListener

class PermissionActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_permission)

        //避免用户手动启动此Activity
        if (!intent.hasExtra(ACCESS_TOKEN)) {
            finish()
        }

        val permissions = intent.getStringArrayExtra("permissions")

        //判断SDK版本
        if (Build.VERSION.SDK_INT >= 23) {
            requestPermissions(permissions, REQUEST_CODE)
        }
    }

    @TargetApi(23)
    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if (requestCode != REQUEST_CODE) {
            return
        }
        //根据选项的不同，调用不同的回调
        for ((index, value) in permissions.withIndex()) {
            if (grantResults[index] == PackageManager.PERMISSION_GRANTED) {//接受
                mPermissionCallback?.onGranted(value)
            }
            if (shouldShowRequestPermissionRationale(value)) {//拒绝，但没有完全拒绝
                mPermissionCallback?.onRationale(value)
            } else {//拒绝
                mPermissionCallback?.onDenied(value)
            }
        }

        finish()
    }

    override fun onDestroy() {
        mPermissionCallback = null
        super.onDestroy()
    }

    companion object {
        private var mPermissionCallback: OnPermissionRequestListener? = null
        /**
         * 通过这个标志位来避免用户手动地打开此Activity,而非调用show方法
         * */
        private const val ACCESS_TOKEN = "token_permission"

        private const val REQUEST_CODE = 10086

        /**
         * 显示此Activity
         * @param context 上下文
         * @param permissions 需要进行请求的权限数组
         * @param callback 处理权限问题的回调
         *
         * @see OnPermissionRequestListener
         * */
        fun show(context: Context, permissions: Array<String>, callback: OnPermissionRequestListener?) {
            mPermissionCallback = callback
            val intent = Intent(context, PermissionActivity::class.java)
            intent.putExtra(ACCESS_TOKEN, ACCESS_TOKEN)
            intent.putExtra("permissions", permissions)
            context.startActivity(intent)
        }
    }
}
