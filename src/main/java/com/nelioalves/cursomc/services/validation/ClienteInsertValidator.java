package com.nelioalves.cursomc.services.validation;

import com.nelioalves.cursomc.domain.enums.TipoCliente;
import com.nelioalves.cursomc.dto.ClienteNewDTO;
import com.nelioalves.cursomc.resources.exceptions.FieldMessage;
import com.nelioalves.cursomc.services.validation.util.BrDocumentValidation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.ArrayList;
import java.util.List;

public class ClienteInsertValidator implements ConstraintValidator<ClienteInsert, ClienteNewDTO> {

   public void initialize(ClienteInsert constraint) {
   }

   public boolean isValid(ClienteNewDTO obj, ConstraintValidatorContext context) {

      List<FieldMessage> fieldMessages = new ArrayList<>();

      if (TipoCliente.PESSOAFISICA.getCodigo().equals(obj.getTipo())
              && !BrDocumentValidation.isValidCPF(obj.getCpfOuCnpj())) {
         fieldMessages.add(new FieldMessage("cpfOuCnpj", "CPF Inválido"));
      }

      if (TipoCliente.PESSOAJURIDICA.getCodigo().equals(obj.getTipo())
              && !BrDocumentValidation.isValidCNPJ(obj.getCpfOuCnpj())) {
         fieldMessages.add(new FieldMessage("cpfOuCnpj", "CNPJ Inválido"));
      }

      for (FieldMessage message : fieldMessages) {
         context.disableDefaultConstraintViolation();
         context.buildConstraintViolationWithTemplate(message.getMessage())
                 .addPropertyNode(message.getFieldName()).addConstraintViolation();
      }
      return fieldMessages.isEmpty();
   }
}
