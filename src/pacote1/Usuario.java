package pacote1;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class Usuario {
	private String	nome;
	private int pontos;
	private boolean moderador;
	
	

	public Usuario(String nome, int pontos) {
		super();
		this.nome = nome;
		this.pontos = pontos;
		this.moderador = false;
	}


	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}


	public int getPontos() {
		return pontos;
	}


	public void setPontos(int pontos) {
		this.pontos = pontos;
	}


	public boolean isModerador() {
		return moderador;
	}


	public void setModerador(boolean moderador) {
		this.moderador = moderador;
	}


	public static void main(String[] args) {
		Usuario user1 = new Usuario("Paulo Silveira", 150);
		Usuario user2 = new Usuario("Rodrigo Turini", 120);
		Usuario user3 = new Usuario("Guilherme Silveira", 190);
		List<Usuario> usuarios = Arrays.asList(user1, user2, user3);
		
		for(Usuario u : usuarios) {
			System.out.println(u.getNome());
		}
		
		System.out.println("1====================");
		
		Consumer<Usuario> mostrador = new Consumer<Usuario>() {
			public void accept(Usuario u) {
			System.out.println(u.getNome());
			}
		};	
		
		System.out.println("2====================");
		
		usuarios.forEach(mostrador);
		
		System.out.println("3====================");
		
		usuarios.forEach(new Consumer<Usuario>() {
			public void accept(Usuario u) {
				System.out.println(u.getNome());
			}
		});
		
		System.out.println("4====================");
		
		Consumer<Usuario> mostrador1 = (Usuario u) -> {System.out.println(u.getNome());};
		
		Consumer<Usuario> mostrador2 = u -> {System.out.println(u.getNome());};
		
		Consumer<Usuario> mostrador3 = u -> System.out.println(u.getNome());
		
		System.out.println("5 Aqui não precisa criar o mostrador ====================");
		
		usuarios.forEach(u -> System.out.println(u.getNome()));
		
		
		Runnable r = new Runnable(){
			public void run(){
			for (int i = 0; i <= 10; i++) {
				System.out.println(i);
			}
			}
		};
		new Thread(r).start();
		
		Runnable r1 = () -> {
			for (int i = 0; i <= 10; i++) {
			System.out.println(i);
			}
		};
		new Thread(r1).start();
		
		new Thread(() -> {
			for (int i = 0; i <= 10; i++) {
				System.out.println(i);
			}
		}).start();

	}

}
