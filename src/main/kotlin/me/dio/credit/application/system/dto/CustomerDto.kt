package me.dio.credit.application.system.dto

import jakarta.validation.constraints.Email
import jakarta.validation.constraints.NotEmpty
import jakarta.validation.constraints.NotNull
import me.dio.credit.application.system.entity.Address
import me.dio.credit.application.system.entity.Customer
import org.hibernate.validator.constraints.br.CPF
import java.math.BigDecimal

data class CustomerDto(
    @field:NotEmpty(message = "Este campo deve ser preenchido") val firstName: String,
    @field:NotEmpty(message = "Este campo deve ser preenchido") val lastName: String,
    @field:NotEmpty(message = "Este campo deve ser preenchido")
    @field:CPF(message = "CPF inválido") val cpf: String,
    @field:NotNull(message = "Este campo deve ser preenchido") val income: BigDecimal,
    @field:NotEmpty(message = "Este campo deve ser preenchido")
    @field:Email(message = "E-mail inválido") val email: String,
    @field:NotEmpty(message = "Este campo deve ser preenchido") val password: String,
    @field:NotEmpty(message = "Este campo deve ser preenchido") val zipCode: String,
    @field:NotEmpty(message = "Este campo deve ser preenchido") val street: String
) {

    fun toEntity(): Customer = Customer(
        firstName = this.firstName,
        lastName = this.lastName,
        cpf = this.cpf,
        income = this.income,
        email = this.email,
        password = this.password,
        address = Address(
            zipCode = this.zipCode,
            street = this.street
        )
    )
}
