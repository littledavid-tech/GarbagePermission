package cn.shycoder.gargabepermissionlibrary

import android.content.Context
import android.os.Build
import cn.shycoder.garbagepermissionlibrary.callbacks.OnPermissionRequestListener


/**
 * GarbagePermission 权限请求框架
 * */
class GarbagePermission private constructor(private val context: Context) {

    private var mPermission: Array<String>? = null
    private var mCallback: OnPermissionRequestListener? = null

    /**
     * 设置你要请求的权限
     * */
    fun permissions(permissions: Array<String>): GarbagePermission {
        mPermission = permissions
        return this
    }

    /**
     * 设置回调
     * */
    fun callback(onPermissionRequestListener: OnPermissionRequestListener): GarbagePermission {
        this.mCallback = onPermissionRequestListener
        return this
    }

    /**
     * 开始请求权限
     * */
    fun request() {
        if (mPermission == null) {
            throw  IllegalArgumentException("Please request permission")
        }
        if (Build.VERSION.SDK_INT >= 23) {
            PermissionActivity.show(context, mPermission!!, mCallback)
        }
    }

    /**
     * GarbagePermission 权限请求框架
     * */
    companion object {
        fun with(context: Context): GarbagePermission {
            return GarbagePermission(context)
        }
    }
}