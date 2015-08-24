package br.com.globalcode.gui;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.ListIterator;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

import br.com.globalcode.facade.JDBCFacade;
import br.com.globalcode.model.Produto;

public class CadastroProdutos extends JFrame {
  
	private static final long serialVersionUID = -950248020901844432L;
	// declaração de variáveis
    private JButton buttonAnterior;
    private JButton buttonCancelar;
    private JButton buttonEditar;
    private JButton buttonNovo;
    private JButton buttonProximo;
    private JButton buttonSalvar;
    private JLabel lbId;
    private JLabel lbMarca;
    private JLabel lbNome;
    private JLabel lbPreco;
    private JPanel pBotões;
    private JPanel pLabels;
    private JPanel pCadastro;
    private JTextField textID;
    private JTextField textMarca;
    private JTextField textNome;
    private JTextField textPreco;
    
    List<Produto> produtos;
    ListIterator<Produto> produtosIterator;
    Produto dataCurrent;
    Produto oldData;
    CadastroProdutosMediator mediator;
    
    
    public CadastroProdutos() {
        initComponents();
        initApp();
    }
    public void initApp() {
        mediator = new CadastroProdutosMediator();
        produtos = JDBCFacade.getInstance().lerProdutos();
        produtosIterator = produtos.listIterator();
        dataCurrent = produtosIterator.next();
        bindCurrentRecord();
    }
    
    public void reinitApp(int index) {
        produtos = JDBCFacade.getInstance().lerProdutos();
        produtosIterator = produtos.listIterator(index);
        dataCurrent = produtosIterator.next();
        bindCurrentRecord();
    }
    
    public void bindCurrentRecord() {
        if(dataCurrent!=null) {
            this.textNome.setText(dataCurrent.getNome());
            this.textID.setText(""+dataCurrent.getId());
            this.textMarca.setText(dataCurrent.getMarca());
            this.textPreco.setText(""+dataCurrent.getPreco());
        }
    }
    
    private void initComponents() {
        pCadastro = new JPanel();
        pLabels = new JPanel();
        lbId = new JLabel();
        textID = new JTextField();
        lbNome = new JLabel();
        textNome = new JTextField();
        lbMarca = new JLabel();
        textPreco = new JTextField();
        lbPreco = new JLabel();
        textMarca = new JTextField();
        pBotões = new JPanel();
        buttonAnterior = new JButton();
        buttonNovo = new JButton();
        buttonEditar = new JButton();
        buttonSalvar = new JButton();
        buttonCancelar = new JButton();
        buttonProximo = new JButton();
        
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setTitle("Cadastro de Produtos");
        setLayout(new BorderLayout(10,5));
        setResizable(false);
        lbId.setText("ID ");
        
        textID.setEditable(false);
        textID.setEnabled(false);
        
        lbNome.setText("Nome");
        
        textNome.setEditable(false);
        
        lbMarca.setText("Marca");
        
        textPreco.setEditable(false);
        
        lbPreco.setText("Pre\u00e7o");
        
        textMarca.setEditable(false);
        
        pLabels.setLayout(new GridLayout(4,1));
        pLabels.add(lbId);
        pLabels.add(lbNome);
        pLabels.add(lbPreco);
        pLabels.add(lbMarca);
        this.add(pLabels, BorderLayout.WEST);
        
        pCadastro.setLayout(new GridLayout(4,1));
        pCadastro.add(textID);
        pCadastro.add(textNome);
        pCadastro.add(textPreco);
        pCadastro.add(textMarca);
        this.add(pCadastro, BorderLayout.CENTER);
        
        
        buttonAnterior.setText("<");
        buttonAnterior.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                mediator.btAnteriorClicked(ae);
            }
        });
        
        pBotões.add(buttonAnterior);
        
        buttonNovo.setText("Novo");
        buttonNovo.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                mediator.btNovoClicked(ae);
            }
        });
        
        pBotões.add(buttonNovo);
        
        buttonEditar.setText("Editar");
        buttonEditar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                mediator.btEditarClicked(ae);
            }
        });
        
        pBotões.add(buttonEditar);
        
        buttonSalvar.setText("Salvar");
        buttonSalvar.setEnabled(false);
        buttonSalvar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                mediator.btSalvarClicked(ae);
            }
        });
        
        pBotões.add(buttonSalvar);
        
        buttonCancelar.setText("Cancelar");
        buttonCancelar.setEnabled(false);
        buttonCancelar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                mediator.btCancelarClicked(ae);
            }
        });
        
        pBotões.add(buttonCancelar);
        
        buttonProximo.setText(">");
        buttonProximo.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                mediator.btProximoClicked(ae);
            }
        });
        
        pBotões.add(buttonProximo);
        
        this.add(pBotões, BorderLayout.SOUTH);
        
        pack();
    }
    
    private void uiEditable(boolean editable) {
        textNome.setEditable(editable);
        textPreco.setEditable(editable);
        textMarca.setEditable(editable);
        buttonSalvar.setEnabled(editable);
        buttonCancelar.setEnabled(editable);
        
        buttonAnterior.setEnabled(!editable);
        buttonEditar.setEnabled(!editable);
        buttonProximo.setEnabled(!editable);
        buttonNovo.setEnabled(!editable);
    }
    
    
    public static void main(String args[]) {
        new CadastroProdutos().setVisible(true);
    }
    
    //Inner class
    class CadastroProdutosMediator {
        private void btAnteriorClicked(ActionEvent ae) {
            if(produtosIterator.hasPrevious())
                dataCurrent = produtosIterator.previous();
            bindCurrentRecord();
            
            uiEditable(false);
        }
        
        public void btNovoClicked(ActionEvent e) {
            oldData = dataCurrent;
            dataCurrent = new Produto();
            bindCurrentRecord();
            
            uiEditable(true);
        }
        
        public void btEditarClicked(ActionEvent e) {
            uiEditable(true);
        }
        
        public void btSalvarClicked(ActionEvent e) {
            int index = 0;
            Produto produto = new Produto(Integer.parseInt(textID.getText()),
                    textNome.getText(),
                    Double.parseDouble(textPreco.getText()),
                    textMarca.getText());
            JDBCFacade.getInstance().salvarProduto(produto);
            
            if(textID.getText().equals("0")) {
                index = produtos.size();
            } else {
                index = produtos.indexOf(dataCurrent);
            }
            
            reinitApp(index);
            
            uiEditable(false);
        }
        
        
        public void btCancelarClicked(ActionEvent e) {
            if (oldData != null) {
                dataCurrent = oldData;
                oldData = null;
            }
            bindCurrentRecord();
            
            uiEditable(false);
        }
        
        public void btProximoClicked(ActionEvent e) {
            if(produtosIterator.hasNext())
                dataCurrent = produtosIterator.next();
            bindCurrentRecord();
            
            uiEditable(false);
        }
    }
}
