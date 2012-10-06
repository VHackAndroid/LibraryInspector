package be.vhackdroid.inspectorlibrary.managers;

import java.io.UnsupportedEncodingException;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.nfc.NdefMessage;
import android.nfc.NdefRecord;
import android.nfc.NfcAdapter;
import android.nfc.Tag;
import android.os.Parcelable;
import android.util.Log;

public class NfcManager {
	protected NfcAdapter mAdapter;
	protected Activity context;
	protected boolean bReadMode = false;
	protected PendingIntent pendingIntent;
	protected IntentFilter tagDetected;
	protected IntentFilter[] filters;
	protected Intent intent;
	protected Tag tag;

	// Constructor.
	public NfcManager(Activity aContext) {
		context = aContext;
		mAdapter = NfcAdapter.getDefaultAdapter(context);
		Log.d("NfcManager constructor", mAdapter.toString());

	}

	public void enableReadMode() {
		bReadMode = true;
		pendingIntent = PendingIntent.getActivity((Context) context, 0,
				new Intent(context, context.getClass())
						.addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP), 0);

		tagDetected = new IntentFilter(NfcAdapter.ACTION_TAG_DISCOVERED);
		filters = new IntentFilter[] { tagDetected };
		mAdapter.enableForegroundDispatch(context, pendingIntent, filters, null);

	}

	/**
	 * @return the pendingIntent
	 */
	public PendingIntent getPendingIntent() {
		Log.d("PENDING_INTENT", pendingIntent.toString());
		return pendingIntent;
	}

	/**
	 * @return the tagDetected
	 */
	public IntentFilter getTagDetected() {
		return tagDetected;
	}

	/**
	 * @return the mAdapter
	 */
	public NfcAdapter getAdapter() {
		return mAdapter;
	}

	/**
	 * @return the filters
	 */
	public IntentFilter[] getFilters() {
		Log.d("INTENT_FILTER", filters.toString());
		return filters;
	}

	/**
	 * @param mAdapter
	 *            the mAdapter to set
	 */
	public void setmAdapter(NfcAdapter mAdapter) {
		this.mAdapter = mAdapter;
	}

	/**
	 * @return the context
	 */
	public Activity getContext() {
		return context;
	}

	/**
	 * @param context
	 *            the context to set
	 */
	public void setContext(Activity context) {
		this.context = context;
	}

	/**
	 * @return the bReadMode
	 */
	public boolean isReadMode() {
		return bReadMode;
	}

	/**
	 * @param bReadMode
	 *            the bReadMode to set
	 */
	public void setReadMode(boolean bReadMode) {
		this.bReadMode = bReadMode;
	}

	public Tag getTag() {
		return tag;
	}

	/**
	 * Set the tag from the NFC adapter. Before using this method, you should
	 * call the NfcManager.setIntent(Intent intent) method.
	 * 
	 * @param intent
	 * @return
	 */
	public boolean process() {
		try {
			tag = intent.getParcelableExtra(NfcAdapter.EXTRA_TAG);
			return true;
		} catch (Exception e) {
			return false;
		}

	}

	public Intent getIntent() {
		return intent;
	}

	public String getTagId() {
		String id = "";
		if (tag != null && intent != null) {
			String action = intent.getAction();
			if (NfcAdapter.ACTION_TAG_DISCOVERED.equals(action)) {

				Log.d("ACTION_TAG_DISCOVERD", "TRUE");

				Parcelable[] rawMsgs = intent
						.getParcelableArrayExtra(NfcAdapter.EXTRA_NDEF_MESSAGES);
				NdefMessage[] msgs;
				if (rawMsgs != null) {
					msgs = new NdefMessage[rawMsgs.length];
					for (int i = 0; i < rawMsgs.length; i++) {
						msgs[i] = (NdefMessage) rawMsgs[i];
					}
				} else {
					// Unknown tag type
					Log.d("UNKNOWN TAG TYPE", "TRUE");
					byte[] empty = new byte[] {};
					NdefRecord record = new NdefRecord(NdefRecord.TNF_UNKNOWN,
							empty, empty, empty);
					NdefMessage msg = new NdefMessage(
							new NdefRecord[] { record });
					msgs = new NdefMessage[] { msg };
				}
				NdefMessage msg = null;
				if(rawMsgs != null){
					Log.d("RAW_MSGS LENGTH",Integer.toString(rawMsgs.length));
				msg = (NdefMessage) rawMsgs[0];
				}

				if (msg != null) {
					try {
						id = new String(msg.getRecords()[0].getPayload(),
								"UTF-8");
						// The 12th character is the id.
						id = id.substring(11);
					} catch (UnsupportedEncodingException e) {
						// TODO Auto-generated catch block
						Log.d("ERROR READING MESSAGE", e.toString());
					}
				}

			} else {
				Log.e("UNKNOWN INTENT", "TRUE");
			}
		}

		return id;

	}

	public void processIntent() {
		if (intent != null) {
			if (NfcAdapter.ACTION_NDEF_DISCOVERED.equals(getIntent()
					.getAction())) {
				// NfcManager.processIntent();
				Parcelable[] rawMsgs = intent
						.getParcelableArrayExtra(NfcAdapter.EXTRA_NDEF_MESSAGES);
				if (rawMsgs != null) {
					NdefMessage[] msgs = new NdefMessage[rawMsgs.length];
					for (int i = 0; i < rawMsgs.length; i++) {
						msgs[i] = (NdefMessage) rawMsgs[i];
					}
				}
			}
		}
		// Parcelable[] rawMsgs = intent
		// .getParcelableArrayExtra(NfcAdapter.EXTRA_NDEF_MESSAGES);
		// if (rawMsgs != null) {
		// NdefMessage[] msgs = new NdefMessage[rawMsgs.length];
		// for (int i = 0; i < rawMsgs.length; i++) {
		// msgs[i] = (NdefMessage) rawMsgs[i];
		// }
		// }
	}

	public void setIntent(Intent intent) {
		this.intent = intent;
	}
	
	public void disableReadMode(){
		mAdapter.disableForegroundDispatch(context);
	}

}
