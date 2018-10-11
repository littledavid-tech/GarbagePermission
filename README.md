# Garbage Permission
### Introduction

​就像项目的名字一样，这一个Garbage 的 `Permission` 请求类库. ​:joy:​ . 

### 展示展示效果图

 ![2018-10-11_20-05-33](img/2018-10-11_20-05-33.png)



### How to use

```kotlin
//Way 1
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
//Way 2
GarbagePermission
        .with(this)
        .permissions(arrayOf(Manifest.permission.READ_EXTERNAL_STORAGE))
        .callback(object : SimpleOnPermissionRequestListener() {
            override fun onGranted(permission: String) {
                Log.e("TAG", "Granted")
            }
        })
        .request()
```



### Add it into your project

To get a Git project into your build:

**Step 1.** Add the JitPack repository to your build file

Add it in your root build.gradle at the end of repositories:

```
	allprojects {
		repositories {
			...
			maven { url 'https://www.jitpack.io' }
		}
	}
```

**Step 2.** Add the dependency

```
	dependencies {
	        implementation 'com.github.littledavid-tech:GarbagePermission:Tag'
	}
```

### Thanks

关于这个开源的 Permission 框架的开发中，[这个博客](https://www.jianshu.com/p/2324a2bdb3d4) 给我了太多的灵感，甚至完全可以说，这个框架的是从那里学习过来的。