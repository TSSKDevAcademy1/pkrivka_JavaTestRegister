package register;

import java.sql.SQLException;

public interface Registerable {

	// Register register=new
	/* (non-Javadoc)
	 * @see register.DatabaseRegisterLoader#writeRegister(register.Register)
	 */
	void writeRegister(Register register) throws Exception;

	/* (non-Javadoc)
	 * @see register.DatabaseRegisterLoader#registerLoad()
	 */
	Register registerLoad() throws Exception;

	/* (non-Javadoc)
	 * @see register.DatabaseRegisterLoader#registerFill(register.Register)
	 */
	void registerFill(Register register);

}