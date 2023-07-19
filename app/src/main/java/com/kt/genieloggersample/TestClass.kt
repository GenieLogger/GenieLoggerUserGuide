package com.kt.genieloggersample

import genie.log.GenieLog

class TestClass {

    fun printCallerStack() {
        // "logger" 가 포함된 클래스 출력
        GenieLog.printCallerStack("logger")
    }

    fun printCallerStackUml() {
        // "logger" 가 포함된 클래스들의 UML 출력
        GenieLog.printCallerStackUML("logger")
    }
}