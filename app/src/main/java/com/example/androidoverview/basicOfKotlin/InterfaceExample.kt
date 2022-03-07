package com.example.androidoverview.basicOfKotlin

interface EmployeeDetails {
    fun getEmployeeName()
    fun getEmployeeId()
}

interface EmployeeSalary {
    fun getEmployeeSalary()
}

class Employee: EmployeeDetails, EmployeeSalary{
    override
    fun getEmployeeName() {
       println("Enter Employee Name")
        var employeeName =  readLine()
    }
    override
    fun getEmployeeId() {
        println("Enter Employee Id")
        var employeeId =  readLine()
    }
    override
    fun getEmployeeSalary() {
        println("Enter Employee Salary ")
        var employeeSalary =  readLine()
    }
}

fun main() {
    val employeeDetails = Employee()
    employeeDetails.getEmployeeId()
    employeeDetails.getEmployeeName()
    employeeDetails.getEmployeeSalary()
}
