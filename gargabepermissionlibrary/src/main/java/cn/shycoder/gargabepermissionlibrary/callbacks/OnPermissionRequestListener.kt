package cn.shycoder.garbagepermissionlibrary.callbacks

/**
 * The callback interface for request permission
 * @see SimpleOnPermissionRequestListener
 */
interface OnPermissionRequestListener {
    /**
     * 当权限被同意的时候，此方法会被调用
     * */
    fun onGranted(permission: String)

    /**
     * 如果权限被完全拒绝(勾选了不再提示复选框) 此方法会被调用
     * */
    fun onDenied(permission: String)

    /**
     * 如果此方法没有被完全地拒绝(没有勾选不再提示复选框)此方法会被调用
     *
     * */
    fun onRationale(permission: String)
}