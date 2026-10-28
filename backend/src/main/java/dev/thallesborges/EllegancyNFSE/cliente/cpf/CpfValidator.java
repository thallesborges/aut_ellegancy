package dev.thallesborges.EllegancyNFSE.cliente.cpf;

public class CpfValidator {
    public static boolean isValido(String cpf) {
        if (cpf.chars().distinct().count() == 1) {
            return false;
        }

        int digito1 = calcularDigito(cpf, 9);
        int digito2 = calcularDigito(cpf, 10);

        return digito1 == Character.getNumericValue(cpf.charAt(9))
                && digito2 == Character.getNumericValue(cpf.charAt(10));
    }

    private static int calcularDigito(String cpf, int quantidade) {
        int soma = 0;
        int peso = quantidade + 1;

        for (int i = 0; i < quantidade; i++) {
            soma += Character.getNumericValue(cpf.charAt(i)) * peso--;
        }

        int resto = soma % 11;
        return (resto < 2) ? 0 : 11 - resto;
    }
}
