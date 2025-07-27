package foodDelivery.form;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class RegisterStoreForm {

    @NotBlank(message = "O CNPJ é obrigatório")
    @Size(min = 14, max = 14, message ="O CNPJ deve conter 14 caracteres")
    private String taxId;

    @NotBlank(message = "O nome fantasia é obrigatório")
    private String tradeName;

    @NotBlank(message = "A razão social é obrigatória")
    private String corporateName;

    @NotBlank(message = "A rua é obrigatória")
    private String street;

    @NotBlank(message = "O número é obrigatório")
    private String number;

    @NotBlank(message = "O bairro é obrigatório")
    private String district;

    @NotBlank(message = "A cidade é obrigatória")
    private String city;

    @NotBlank(message = "O estado é obrigatório")
    private String state;

    @NotBlank(message = "O CEP é obrigatório")
    private String zipCode;
}
