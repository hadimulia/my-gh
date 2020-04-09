package com.app.generic.core.constant;

import java.util.HashMap;

import com.app.generic.core.exception.Error;

/**
 * This class is only for ErrorMessage & ErrorCode constant value.
 * <p><b>NOTE:</b> ErrorCode and ErrorMessage value pattern is like this, for example:
 * <li>{ERR0RCOD3};{ERR0RM3SSAG3}
 * <li>ErrorCode and ErrorMessage must be separately with <b>;</b>
 * 
 * @author M Lukmanul Hakim (m.hakim &copy;Sep 21, 2018) 
 * <br>for further info contact: <i>vickyhakimm@gmail.com</i>
 */

public class ErrorConstant {
	public static final Error SUCCESS 				= new Error("GEN-100","Process successful. ","Proses Berhasil.",200);
	public static final Error FAILED 				= new Error("GEN-101","Process failed. ","Proses Gagal.",400);					//TODO					
	public static final Error PARSING_ERROR			= new Error("GEN-102","Parsing error. ","Kesalahan parsing.",400); 	//TODO		
	public static final Error INVALID_PARAMETER		= new Error("GEN-103","Invalid parameter. ","Parameter tidak sesuai.",400);
	public static final Error INCOMPLETE_FIELD		= new Error("GEN-104","Missing mandatory field. ","Kolom wajib tidak ditemukan.",400);	
	public static final Error MALFORMED_MESSAGE		= new Error("GEN-105","Malformed message format. ","Format pesan salah.",400);
	public static final Error INVALID_DATE			= new Error("GEN-106","Invalid date format. ","Format tanggal tidak sesuai.",400);
	public static final Error EMPTY_BODY			= new Error("GEN-107","Body can't be empty."," Request Body tidak bisa kosong.",400);
	public static final Error NULL_ENTITY			= new Error("GEN-108","Entity can't be null or empty"," Entitas tidak bisa kosong.",400);
	public static final Error INVALID_EXPIRED_DATE	= new Error("GEN-109","Expired Date can't before current date. ", "Tanggal Kadaluarsa tidak bisa kurang dari tanggal sekarang. ",400);	//TODO
	
	public static final Error FILE_NOT_FOUND		= new Error("GEN-400","File not found.","File Tidak DItemukan",404);
	public static final Error ACCESS_DENIED			= new Error("GEN-401","Access denied.","Akses ditolak.",401);
	public static final Error CANNOT_INSERT_DATA	= new Error("GEN-402","Cannot insert data, check your application log.", "Tidak dapat menambah data, silahkan cek log aplikasi. ", 500);	//TODO
	public static final Error FATAL_ERROR 			= new Error("GEN-500", " Fatal error.", "Kesalahan Fatal", 500); // TODO
	
	
	
	// ----------------------------------- BUSINESS PROCESS USER ERROR CODE : 20xx - 21xx -----------------------------------
	public static final Error BAD_CREDENTIAL			= new Error("GEN-201","Bad credential. ","Kredensial buruk",401);	
	public static final Error USER_LOCKED				= new Error("GEN-202","User is locked. ","Pengguna terkunci.",400);			//TODO
	public static final Error USER_DISABLED				= new Error("GEN-203","User is disabled. ","Pengguna dinonaktifkan.",400);	//TODO
	public static final Error USER_INACTIVE				= new Error("GEN-204","User is inactive. ","Pengguna tidak aktif.",400);	//TODO
	public static final Error AUTHENTICATION_FAILED		= new Error("GEN-205","Authentication failed. ","Otentikasi gagal.",401);
	public static final Error UNAUTHORIZED_ACCESS		= new Error("GEN-206","Unauthorized access. ","Akses tidak sah.",401);
	public static final Error SESSION_TIMEOUT			= new Error("GEN-207","Timeout has reached when accessing application. ","Waktu telah habis saat mengakses aplikasi. ",408);	//TODO
	public static final Error MAX_LOGIN_ATTEMPT			= new Error("GEN-208","Max login attempt has been reached. ","Percobaan login telah mencapai batas maksimum.",401);
	public static final Error CONSECUTIVE_PASSWORD		= new Error("GEN-209","Do not input consecutive characters. ","Jangan memasukkan karakter berurutan.",400);
	public static final Error UNIQUE_PASSWORD			= new Error("GEN-210","Input unique characters. ","Masukkan karakter unik.",400);
	public static final Error CUSTOMER_NOT_FOUND		= new Error("GEN-211","Customer not found. ","Nasabah tidak ditemukan",404); //TODO
	public static final Error ACCOUNT_BLOCKED_PERMANENT	= new Error("GEN-212","Account has permanently blocked. ","Rekening telah diblokir permanen.",403);	
    // ----------------------------------- BUSINESS PROCESS TRANSACTION ERROR CODE : 22xx - 23xx -----------------------------------
	public static final Error TRANSACTION_NOT_FOUND		= new Error("GEN-300","Transaction not found. ","Transaksi tidak ditemukan.",404);  
    
    // ----------------------------------- BUSINESS PROCESS TRANSACTION ERROR CODE : 3xxx - 3999 -----------------------------------
	public static final Error TRANSACTION_CODE_FOUND			= new Error("GEN-301","Transaction Code not found. ","Kode transaksi tidak ditemukan.",404);
	public static final Error ACCOUNT_BALANCE					= new Error("GEN-302","Account does not have sufficient balance. ","Rekening tidak memiliki saldo yang cukup.",400);
	public static final Error ACCOUNT_BALANCE_BLOCKED			= new Error("GEN-303","Account does not have sufficient balance, some amount has been blocked. ","Rekening tidak memiliki saldo yang cukup, beberapa rekening telah diblokir.",400);
	public static final Error ACCOUNT_NOT_FOUND					= new Error("GEN-304","Account not found. ","Rekening tidak ditemukan.",404);
	public static final Error LEDGER_ACCOUNT_NOT_FOUND			= new Error("GEN-305","Ledger Account not found. ","Akun Buku Besar tidak ditemukan",404);
	public static final Error USER_LIMIT						= new Error("GEN-306","User does not have enough limit to do this transaction. ","Pengguna tidak memiliki limit yang cukup untuk melakukan transaksi ini.",400);
	public static final Error AUTHORIZATION_TRANSACTION			= new Error("GEN-307","Need authorization for transaction. ","Butuh otorisasi untuk transaksi.",403);
	public static final Error AUTHORIZATION_STP					= new Error("GEN-308","Above STP, Need authorization for transaction. ","Di atas STP, butuh otorisasi untuk transaksi.",403);
	public static final Error SVA_CUSTOMER_ERROR				= new Error("GEN-309","1 customer can only have max 2 accounts in 1 product in Register Stored Value Account ","1 nasabah hanya dapat memiliki maksimal 2 rekening dalam 1 produk di Register Stroed Value Account",400);
	public static final Error ACCOUNT_NUMBER_NOT_FOUND			= new Error("GEN-310","Account number not found. ","Nomor rekening tidak ditemukan.",404);
	public static final Error PRODUCT_NOT_VALID					= new Error("GEN-311","Product not Valid. ","Produk tidak sesuai.",400);
	public static final Error CIF_ACCOUNT_NOT_FOUND				= new Error("GEN-312","Account in ID CIF not found. ","Rekening di ID CIF tidak ditemukan.",404);
	public static final Error CIF_NOT_FOUND						= new Error("GEN-313","CIF not found. ","CIF tidak ditemukan.",404);
	public static final Error ACCOUNT_CLOSED					= new Error("GEN-314","Account is already closed. ","Rekening telah ditutup.",400); 	//TODO
	public static final Error CIF_ACCOUNT_NOT_EQUAL				= new Error("GEN-316","CIF Number of accounts not equals. ","Nomor CIF rekening tidak sama.",400);
	public static final Error IDENTITY_NUMBER_NOT_FOUND			= new Error("GEN-317","Identity Number not found. ","Nomor Identitas tidak ditemukan.",404);
	public static final Error USER_APPROVAL_ERROR				= new Error("GEN-318","User approval must be different with inputter. ","Persetujuan pengguna harus berbeda dengan inputter.",400);
	public static final Error ACCOUNT_BALANCE_NOT_ZERO			= new Error("GEN-319","Account balance not zero. ","Saldo rekening tidak nol.",400);
	public static final Error TRANSACTION_PRIVILEGE				= new Error("GEN-320","Insufficient privilege to perform transaction for account. ","Tidak cukup hak untuk melakukan transaksi untuk rekening.",403);
	public static final Error USER_TELLER_NOT_FOUND				= new Error("GEN-321","User is not available. ","Pengguna tidak tersedia.",400);
	public static final Error NOT_ALLOWED_DEBIT					= new Error("GEN-322","Account is not allowed to make debit transaction ","Rekening tidak diijinkan untuk melakukan transaksi debit.",403);
	public static final Error NOT_ALLOWED_CREDIT				= new Error("GEN-323","Account is not allowed to make credit transaction ","Rekening tidak diijinkan untuk melakukan transaksi kredit.",403);
	public static final Error ACCOUNT_EXCEED_MAX_BALANCE		= new Error("GEN-324","Account exceed it's maximum balance ","Rekening melampaui batas saldo maksimum.",400);
	public static final Error ACCOUNT_EXCEED_MIN_BALANCE		= new Error("GEN-325","Account exceed it's minimum balance ","Rekening melampaui batas saldo minimum.",400);
	public static final Error USER_TELLER_ACCOUNT_NOT_FOUND		= new Error("GEN-326","Teller Account is not available. ","Rekening Teller tidak tersedia.",400);
	public static final Error CIF_EXIST 						= new Error("GEN-327","CIF already exists. ","CIF telah tersedia.",400);
	public static final Error ACCOUNT_EXIST						= new Error("GEN-328","Account Number already exists. ","Nomor rekening telah tersedia.",400);
	public static final Error USER_TELLER_ACCOUNT_NOT_ENOUGH	= new Error("GEN-329","Teller Account is not enough. ","Rekening Teller tidak cukup.",400);
	public static final Error LIMIT_DEBIT_TRX					= new Error("GEN-330","Account exceed limit of debit transaction. ","Rekening melebihi batas transaksi debit.",400);
	public static final Error LIMIT_FREQUENCY_TRX				= new Error("GEN-331","Account exceed limit of frequency transaction. ","Rekening melebihi batas frekuensi transaksi.",400);
	public static final Error MINIMUM_DEPOSIT_AMOUNT			= new Error("GEN-332","Minimum Deposit Amount Should be equal or More Than  ","Nominal minimum deposit harus sama atau lebih dari.",400);
	public static final Error ACCOUNT_BLOCKED					= new Error("GEN-333","Account is blocked. ","Rekening diblokir.",403);	//TODO
	public static final Error IDENTITY_NUMBER_EXIST				= new Error("GEN-334","Identity Number has been used. ","Nomor Identitas telah digunakan.",400);
	public static final Error INVALID_AMOUNT					= new Error("GEN-335","Amount shoud be more than 0. ","Nominal harus lebih dari 0.",400);
	public static final Error LIMIT_CREDIT_TRX					= new Error("GEN-336","Account exceed limit of credit transaction. ","Rekening melebihi batas transaksi kredit.",400);
	public static final Error PRIMARY_PHONE						= new Error("GEN-337","Primary cannot be more than one. ","Telepon utama tidak dapat lebih dari satu.",400);
	public static final Error PHONE								= new Error("GEN-338","Phone number must have one primary. ","Nomor telepon harus memiliki satu nomor utama.",400);
	public static final Error DATA_EXIST						= new Error("GEN-397","Data is already exist.    ","Data telah tersedia.",400);
	public static final Error INVALID_DATA_ENTRY				= new Error("GEN-398","Invalid data entry. ","Data yang dimasukkan tidak sesuai.",400);
	public static final Error EMPTY_RECORD						= new Error("GEN-399","Record cannot be empty. ","Catatan tidak dapat kosong.",400);
	public static final Error ACCOUNT_INACTIVE					= new Error("GEN-300","Account is inactive. ","Rekening tidak aktif.",400); //TODO
	public static final Error BELOW_MINIMUM_DEPOSIT				= new Error("GEN-301","Amount below minimum deposit ","Nominal di bawah minimum deposit.",400);
	public static final Error LIMIT_AMOUNT_TRX					= new Error("GEN-302","Transaction exceeds the maximum limit amount. ","Transaksi melebihi nominal limit maksimum.",400);
	public static final Error LIMIT_FREQUENCY_TRXCODE			= new Error("GEN-303","Transaction exceeds the maximum frequency limit. ","Transaksi melebihi frekuensi limit maksimum.",400);
	public static final Error MISMATCH							= new Error("GEN-304","Record mismatch ","Catatan tidak sesuai.",400);
	public static final Error THRESHOLD_MINUS					= new Error("GEN-305","Threshold Amount must be greater than or equals 0. ","Nominal ambang harus lebih besar atau sama dengan 0.",400);
	public static final Error ACCOUNT_DORMANT					= new Error("GEN-306","Account is dormant. ","Rekening dorman.",400);	//TODO
	public static final Error REFERENCE_NUMBER_EXIST			= new Error("GEN-307","Reference number should not be the same. ","Nomor referensi harus berbeda.",400);
	public static final Error CIN_NOT_ALLOWED_SPECIAL_CHARACTER = new Error("GEN-308","CIN Can not use special characters. ","CIN tidak dapat menggunakan karakter spesial.",400);
	public static final Error CANNOT_OPENING_ACCOUNT			= new Error("GEN-309","Opening account not allowed ","Pembukaan rekening tidak diijinkan.",400);
	public static final Error BRANCH_NOT_FOUND					= new Error("GEN-310","Branch not found. ","Cabang tidak ditemukan.",400);
	public static final Error CIF_MANDATORY_EMPTY_FIELDS		= new Error("GEN-311","One or more fields can not be empty. ","Satu atau lebih kolom tidak dapat dikosongkan.",400);
	public static final Error GL_CODE_DEBIT_INVALID				= new Error("GEN-312","GL Code Debit not found. ","Kode GL Debit tidak ditemukan.",400);
	public static final Error GL_CODE_CREDIT_INVALID			= new Error("GEN-313","GL Code Credit not found. ","Kode GL Kredit tidak ditemukan.",400);
	public static final Error PHONE_TYPE_DIFFERENCE				= new Error("GEN-314","Phone number and phone type already exists ","Nomor telepon dan tipe telepon telah tersedia.",400);
	public static final Error CANNOT_EDIT_ACCOUNT             	= new Error("GEN-315","Update account not allowed ","Pembaharuan rekening tidak diijinkan.",400);
	public static final Error NOT_PRODUCT_SVA             		= new Error("GEN-316","Product type is not stored value account (SVA) ","Tipe produk buka Stored Value Account (SVA).",403);	//TODO
	public static final Error PHONE_TYPE_EMPTY					= new Error("GEN-317","Phone type cannot be empty ","Tipe Telepon tidak dapat dikosongkan.",400);
	public static final Error PHONE_NUMBER_EMPTY				= new Error("GEN-318","Phone number cannot be empty ","Nomor Telepon tidak dapat dikosongkan.",400);
	public static final Error INVALID_PIN						= new Error("GEN-319","Invalid pin number ","Nomor PIN tidak sesuai.",400);
	public static final Error ACCOUNT_EMPTY						= new Error("GEN-320","Account number cannot be empty ","Nomor rekening tidak dapat dikosongkan.",400);
	
	public static final Error MORE_THAN_ONE_ACCOUNT				= new Error("GEN-321","More than 1 account is found ","Ditemukan lebih dari 1 rekening.",400);
	public static final Error OUTSTANDING_MORE_THEN_ZERO		= new Error("GEN-322","Account still has outstanding. ","Rekening masih memiliki saldo.",400);
    
	public static final Error UNAUTHORIZED_TRANSACTION_EXIST	= new Error("GEN-323","Unauthorized transaction(s) exist, account can not be closed. ","Terjadi transaksi yang tidak sah, rekening tidak dapat ditutup.",400);	//TODO
	public static final Error ACCOUNT_HAS_SOME_BLOCKED_AMOUNT	= new Error("GEN-324","Account has some blocked amount, account cannot be closed. ","Rekening memiliki saldo blokir, rekening tidak dapat ditutup.",400);	//TODO
	public static final Error ACCOUNT_TO_FROM_MUST_BE_DEFERENT 	= new Error("GEN-325","Account from and Account to must be deferent. ","Rekening Dari dan Rekening Tujuan harus berbeda.",400);
	public static final Error DESC_EMPTY 						= new Error("GEN-326","Description cannot be empty. ","Deskripsi tidak dapat dikosongkan.",400);
	public static final Error CANNOT_EDIT_PRODUCT             	= new Error("GEN-327","Update product not allowed ","Pembaharuan produk tidak diijinkan.",400);		//TODO
 	
	public static final Error INTEREST_CODE_EXIST 				= new Error("GEN-328","Interest code already exist. ","Interest code sudah tersedia.",400);
	public static final Error INTEREST_CODE_NOT_FOUND 			= new Error("GEN-329","Interest code not found. ","Interest code tidak ditemukan.",400);
	public static final Error PRODUCT_USED						= new Error("GEN-330","Product already use. ","Produk sudah digunakan.",400);
	public static final Error INVALID_PERIOD_DATE 				= new Error("GEN-331","Period date is invalid. ","Periode tanggal salah.",400);
	public static final Error BASE_INTEREST_EXIST				= new Error("Gen-332","Base interest already exist. ", "Base interest sudah tersedia.", 400);
	
	
	public static final Error RECORD_NOT_FOUND			= new Error("GEN-400","Record not found in database. ","Catatan tidak ditemukan di database.",404);	//TODO
	public static final Error RECORD_NOT_SHORT_TYPE		= new Error("GEN-401","Type CIF is not short. ","Tipe CIF tidak pendek.",400);
	public static final Error DIFFERENT_CODE_BRANCH		= new Error("GEN-402","Different Code Branch. ","Kode Cabang berbeda.",400);
    public static final Error INVALID_PRODUCT_ID_REFERENCE  = new Error("GEN-403","Invalid Product_Id Referenced. ","Produk_Id Tidak Direferensikan.",400);
    public static final Error ACCOUNTNO_NOT_EDITABLE  = new Error("GEN-404","Account Number is not Editable.","Nomor Akun tidak dapat Diedit",400);

    // ----------------------------------- DATABASE ERROR CODE : 6xxx -----------------------------------
	public static final Error DATA_NOT_FOUND				=new Error("GEN-600", "Data not found. ", "Data tidak ditemukan.",404);
    
    // ----------------------------------- DATABASE ERROR ACCOUNT CODE : 61xx -----------------------------------
	public static final Error DATA_ACCOUNT_NOT_FOUND		= new Error("GEN-700","Account not found. ","Rekening tidak ditemukan.",404);
	public static final Error DATA_ACCOUNT_IS_EXIST			= new Error("GEN-701","Account is exist. ","Rekening tidak tersedia.",400);	//TODO
	public static final Error DATA_ACCOUNT_MAX_PRODUCT		= new Error("GEN-702","This CIF has account limit for this product ","CIF memiliki batas rekening untuk produk ini.",400);
    
    // ----------------------------------- UNKNOWN ERROR CODE : 9xxx -----------------------------------
	public static final Error UNKNOWN_ERROR					= new Error("GEN-999","Unknown error has occured.","Terjadi eror yang tidak diketahui.",500);
	public static final Error SYSTEM						= new Error("GEN-998","Unknown error has occured.","Terjadi eror yang tidak diketahui.",500);
		
	/*
	 * Validation error code does not have http status
	 * */
	// ----------------------------------- Validation ERROR CODE : VAL -1xx -----------------------------------
	public static final Error REQUIRED_FIELD 			= new Error("VAL-100","Field is Required","Field harus diisi");
	public static final Error INVALID_CONTACT_NUMBER 	= new Error("VAL-101","Invalid Contact number value, minimum value > 8 <=15 digit","Nomor kontak tidak valid, nilai minimum > 8 <=13 digit");
	public static final Error INVALID_NUMBER_FORMAT 	= new Error("VAL-102","Invalid number format","Format nomor tidak valid");
	public static final Error INVALID_DATE_FORMAT 		= new Error("VAL-103","Invalid date format","Format tanggal tidak valid");
	public static final Error INVALID_EMAIL_VALUE 		= new Error("VAL-104","Invalid email format","format email tidak valid");	
	public static final Error INVALID_DATE_RANGE 		= new Error("VAL-105","Invalid date range between StartDate and EndDate","Jarak antara tanggal mulai dan tanggal akhir tidak valid");
	public static final Error INVALID_MIN_MAX 			= new Error("VAL-106","Invalid value between MIN and MAX","Jarak antara minimum dan maksimum tidak valid");
	public static final Error INVALID_POSITIVE_NUMBER	= new Error("VAL-107","Number must be positive","Angka harus positif");
    public static final Error WITHOUT_SPECIAL_CHARACTER = new Error("VAL-108","Special character is forbidden","Tidak boleh menggunakan karakter spesial");
    public static final Error INVALID_BOOLEAN_FORMAT	= new Error("VAL-109","Invalid Boolean Format, only true or false is accepted","Format Boolean tidak valid, hanya true atau false yang diterima");
    
	public static final String INVALID_EMAIL_VALUE_KEY ="INVALID_EMAIL_VALUE";
	public static final String INVALID_NUMBER_FORMAT_KEY="INVALID_NUMBER_FORMAT";
	public static final String INVALID_CONTACT_NUMBER_KEY = "INVALID_CONTACT_NUMBER";
	public static final String INVALID_DATE_FORMAT_KEY = "INVALID_DATE_FORMAT";
	public static final String REQUIRED_FIELD_KEY = "REQUIRED_FIELD";
	public static final String INVALID_DATE_RANGE_KEY = "INVALID_DATE_RANGE";
	public static final String INVALID_MIN_MAX_KEY = "INVALID_MIN_MAX";
	public static final String INVALID_POSITIVE_NUMBER_KEY = "INVALID_POSITIVE_NUMBER";
    public static final String WITHOUT_SPECIAL_CHARACTER_KEY = "WITHOUT_SPECIAL_CHARACTER";
	public static final String UNKNOWN_ERROR_KEY = "UNKNOWN_ERROR";
	public static final String INVALID_EXPIRED_DATE_KEY = "INVALID_EXPIRED_DATE";
	public static final String INVALID_BOOLEAN_FORMAT_KEY = "INVALID_BOOLEAN_FORMAT";

	
	protected static HashMap<String, Error> errors ;
	static {
		errors = new HashMap<>();
		errors.put(INVALID_EMAIL_VALUE_KEY, INVALID_EMAIL_VALUE);
		errors.put(INVALID_NUMBER_FORMAT_KEY, INVALID_NUMBER_FORMAT);
		errors.put(INVALID_CONTACT_NUMBER_KEY, INVALID_CONTACT_NUMBER);
		errors.put(INVALID_DATE_FORMAT_KEY, INVALID_DATE_FORMAT);
		errors.put(REQUIRED_FIELD_KEY, REQUIRED_FIELD);
		errors.put(INVALID_DATE_RANGE_KEY, INVALID_DATE_RANGE);
		errors.put(UNKNOWN_ERROR_KEY, UNKNOWN_ERROR);
		errors.put(INVALID_MIN_MAX_KEY, INVALID_MIN_MAX);
		errors.put(INVALID_POSITIVE_NUMBER_KEY, INVALID_POSITIVE_NUMBER);
        errors.put(WITHOUT_SPECIAL_CHARACTER_KEY, WITHOUT_SPECIAL_CHARACTER);
        errors.put(INVALID_EXPIRED_DATE_KEY, INVALID_EXPIRED_DATE);
        errors.put(INVALID_BOOLEAN_FORMAT_KEY, INVALID_BOOLEAN_FORMAT);
	}

	/**
	 * @param exceptionKey ErrorConstant String value
	 * @return {@link Error} based of key string value
	 * @author kusmawati
	 **/
	public static Error getError (String exceptionKey){
		Error err =errors.get(exceptionKey);
		return err;
	}
	
}
