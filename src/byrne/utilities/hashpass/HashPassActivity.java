package byrne.utilities.hashpass;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import android.app.Activity;
import android.os.Bundle;
import android.text.ClipboardManager;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class HashPassActivity extends Activity implements OnClickListener , OnItemSelectedListener{
   
	//declare ui components and strings
	private EditText input;
	private EditText output;
	private Button  generate;
	private Spinner hash_type;
	private String hash_choice;
	private String output_str;
	
	
	
	/** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        //get references
        
        input = (EditText) findViewById(R.id.input);
        output = (EditText) findViewById(R.id.output);
        generate = (Button) findViewById(R.id.gen);
        hash_type = (Spinner) findViewById(R.id.hash_type);
        
        //set listeners
        generate.setOnClickListener(this);
        hash_type.setOnItemSelectedListener(this);
                
    }
    
	@Override
	public void onClick(View v) {
				
		// if there is text entered
		if (v == generate && input.getText().toString().length() !=0 ){
			 
			ClipboardManager clipboard = 
				      (ClipboardManager) getSystemService(CLIPBOARD_SERVICE); 

			if(hash_choice.equals(getResources().getString(R.string.md5)) || 
					hash_choice.equals(getResources().getString(R.string.sha1)) ||
					hash_choice.equals(getResources().getString(R.string.sha256)) || 
					hash_choice.equals(getResources().getString(R.string.sha512))){
				
				output_str = createHash(input.getText().toString(),hash_choice);
				output.setText(output_str);
				clipboard.setText(output_str);
				Toast.makeText(this, "hash copied to clipboard", Toast.LENGTH_SHORT).show();
			}
		}
		else{
			//display error message	
			Toast.makeText(this,"input must not be empty", Toast.LENGTH_SHORT).show();
		}
		
		
	}

	@Override
	public void onItemSelected(AdapterView<?> arg0, View v, int position,
			long id) {
		
		
		//md5
		if(position == 0)
			hash_choice = getResources().getString(R.string.md5);

		//sha1
		if(position == 1)			
			hash_choice = getResources().getString(R.string.sha1);

		//sha256
		if(position == 2)
			hash_choice = getResources().getString(R.string.sha256);
		
		//sha512
		if(position == 3)
			hash_choice = getResources().getString(R.string.sha512);

			
		//clear the output box
		output.setText("");
		
	}

	
	//Can ignore this method
	@Override
	public void onNothingSelected(AdapterView<?> arg0) {
		// TODO Auto-generated method stub
		
	}


    
    
    /***
     * Create a hash of various types
     * @param String input : The String to be hashed
     * @param String type  : The hashing algorithm 
     * 
     * @return String hash : The resulting hash
     * */
	
    private String createHash(String input, String type){
    	
    	
    	byte[] bytesOfMessage;
    	
		try {
			bytesOfMessage = input.getBytes("UTF-8");
			
			MessageDigest md;
			try {
				md = MessageDigest.getInstance(type);
				
				byte[] thedigest = md.digest(bytesOfMessage);				
				
				final char[] HEX_CHARS = "0123456789abcdef".toCharArray();

				StringBuilder sb = new StringBuilder(thedigest.length * 2);
				for (byte b : thedigest) {
				    sb.append(HEX_CHARS[(b & 0xF0) >> 4]);
				    sb.append(HEX_CHARS[b & 0x0F]);
				}
				
				return sb.toString();
				
				
				//should not occur due to limited input choices
				// and no null options available
			} catch (NoSuchAlgorithmException nsae) {
				nsae.printStackTrace();
			}
	    	
			//should not occur due to hard coded encoding choice
		} catch (UnsupportedEncodingException uee) {
			uee.printStackTrace();
		}

    	// returns null if it was unable to perform the hashing
		return "NULL";
    	
    }
}

