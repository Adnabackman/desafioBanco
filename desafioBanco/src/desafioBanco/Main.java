package desafioBanco;

public class Main {
    
    public static void main(String[] args) {
        Banco bancoCentral = new Banco("Banco Central");
        
        Cliente adna = new Cliente();
        adna.setNome("Adna");
        
        ContaCorrente cc = new ContaCorrente(adna);
        ContaPoupanca cp = new ContaPoupanca(adna);

        bancoCentral.adicionarConta(cc);
        bancoCentral.adicionarConta(cp);

        try {
            System.out.println("--- Realizando operações válidas ---");
            cc.depositar(100);
            System.out.println("Depósito de R$100.00 na Conta Corrente realizado com sucesso.");
            cc.transferir(50, cp);
            System.out.println("Transferência de R$50.00 da Conta Corrente para a Conta Poupança realizada com sucesso.");
        } catch (ValorInvalidoException | SaldoInsuficienteException e) {
            System.out.println("Erro na operação: " + e.getMessage());
        }

        System.out.println("\n--- Extrato após operações válidas ---");
        cc.imprimirExtrato();
        System.out.println("---------------------------------");
        cp.imprimirExtrato();
        
        System.out.println("\n--- Tentando realizar uma operação inválida ---");
        try {
            cc.sacar(200); 
        } catch (SaldoInsuficienteException e) {
            System.out.println("Erro na operação: " + e.getMessage());
        } catch (ValorInvalidoException e) {
            System.out.println("Erro na operação: " + e.getMessage());
        }

        System.out.println("\n--- Extrato após tentativa de operação inválida ---");
        cc.imprimirExtrato(); 
    }
}