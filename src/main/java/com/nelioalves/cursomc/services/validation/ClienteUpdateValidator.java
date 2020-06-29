package com.nelioalves.cursomc.services.validation;

import com.nelioalves.cursomc.domain.Cliente;
import com.nelioalves.cursomc.dto.ClienteDTO;
import com.nelioalves.cursomc.repositories.ClienteRepository;
import com.nelioalves.cursomc.resources.exceptions.FieldMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerMapping;

import javax.servlet.http.HttpServletRequest;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ClienteUpdateValidator implements ConstraintValidator<ClienteUpdate, ClienteDTO> {

   @Autowired
   private ClienteRepository repository;

   @Autowired
   private HttpServletRequest request;

   public void initialize(ClienteUpdate constraint) {
   }

   public boolean isValid(ClienteDTO obj, ConstraintValidatorContext context) {

      Map<String, String> attributes = (Map<String, String>)request.getAttribute(HandlerMapping.URI_TEMPLATE_VARIABLES_ATTRIBUTE);
      Integer uriId = Integer.parseInt(attributes.get("id"));

      List<FieldMessage> fieldMessages = new ArrayList<>();

      Cliente cliente = repository.findByEmail(obj.getEmail());

      if (cliente != null && !cliente.getId().equals(uriId)) {
         fieldMessages.add(new FieldMessage("email", "Email já cadastrado"));
      }

      for (FieldMessage message : fieldMessages) {
         context.disableDefaultConstraintViolation();
         context.buildConstraintViolationWithTemplate(message.getMessage())
                 .addPropertyNode(message.getFieldName()).addConstraintViolation();
      }
      return fieldMessages.isEmpty();
   }
}
