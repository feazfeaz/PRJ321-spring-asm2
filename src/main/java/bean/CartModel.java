package bean;

/////// not today

public class CartModel extends Model {

	int idUser;
	int idProd;

	public CartModel(int idUser, int idProd) {
		super();
		this.idUser = idUser;
		this.idProd = idProd;
	}

	public CartModel() {
		super();
	}

	public int getIdUser() {
		return idUser;
	}

	public void setIdUser(int idUser) {
		this.idUser = idUser;
	}

	public int getIdProd() {
		return idProd;
	}

	public void setIdProd(int idProd) {
		this.idProd = idProd;
	}

}
