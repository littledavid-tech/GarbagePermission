package cn.shycoder.garbagepermissionlibrary.callbacks


import cn.shycoder.garbagepermissionlibrary.callbacks.OnPermissionRequestListener

/**
 * 如果你觉得 OnPermissionRequestListener 这个接口回调，需要实现所有的函数，
 * 可能这些函数有些你并不需要,那么你可以采用这个类，来重写你关心的方法即可
 * @see OnPermissionRequestListener
 */
open class SimpleOnPermissionRequestListener : OnPermissionRequestListener {
    override fun onGranted(permission: String) {
    }

    override fun onDenied(permission: String) {
    }

    override fun onRationale(permission: String) {
    }
}