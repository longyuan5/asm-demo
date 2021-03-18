package com.example.testplugin.visitor.cv

import com.example.testplugin.AndExt
import com.example.testplugin.utils.ADLog
import com.example.testplugin.utils.AccessCodeUtils
import com.example.testplugin.visitor.BaseClassInterceptor
import com.example.testplugin.visitor.mv.DeleteLogInterceptor
import com.example.testplugin.visitor.mv.PrintLogInterceptor
import com.example.testplugin.visitor.mv.TryCatchInterceptor
import org.objectweb.asm.ClassVisitor
import org.objectweb.asm.MethodVisitor

internal class AndExtensionInterceptor(api: Int, classVisitor: ClassVisitor?, var andExt: AndExt?) : BaseClassInterceptor(api, classVisitor) {

    override fun visitMethod(access: Int, name: String?, descriptor: String?, signature: String?, exceptions: Array<out String>?): MethodVisitor {
        ADLog.info("开始访问方法： name = $name, access = ${AccessCodeUtils.accessCode2String(access)}, descriptor = $descriptor")
        var methodVisitor = cv.visitMethod(access, name, descriptor, signature, exceptions)
        if (andExt!!.printLog) {
            ADLog.error("PrintLogInterceptor")
            methodVisitor = PrintLogInterceptor(className, methodVisitor, access, name, descriptor)
        }
        if (andExt!!.deleteLog) {
            ADLog.error("DeleteLogInterceptor")
            methodVisitor = DeleteLogInterceptor(methodVisitor, access, name, descriptor)
        }

        if (andExt!!.tryCatch) {
            ADLog.error("TryCatchInterceptor")
            methodVisitor = TryCatchInterceptor(methodVisitor, access, name, descriptor)
        }
        return methodVisitor
    }
}