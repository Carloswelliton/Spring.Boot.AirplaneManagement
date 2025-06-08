package br.edu.ifms.AirlineManagement.service;


import javax.swing.*;

public class VerifyInfo {

  public boolean cpfValidate(String cpf){
    var dados = cpf.replaceAll("[^0-9]", "");

    if (dados.length() != 11 || dados.chars().distinct().count() == 1) {
      JOptionPane.showMessageDialog(null, "CPF inválido");
      return false;
    }
    String subCpf = dados.substring(0,9);
    subCpf += verifierDigit(subCpf);
    subCpf += verifierDigit(subCpf);
    if(subCpf.equals(dados)){
      JOptionPane.showMessageDialog(null, "CPF válido");
      return true;
    }else{
      JOptionPane.showMessageDialog(null, "CPF inválido");
      return false;
    }
  }

  public String verifierDigit(String base){
    var multiplier = base.length() +1;
    var sum = 0;
    for (int i = 0; i < base.length(); i++) {
      int digit = Character.getNumericValue(base.charAt(i));
      sum += digit*multiplier;
      multiplier--;
    }
    int remainder = sum % 11;
    int digit = (remainder < 2)? 0 : 11 - remainder;
    return String.valueOf(digit);
  }
}
