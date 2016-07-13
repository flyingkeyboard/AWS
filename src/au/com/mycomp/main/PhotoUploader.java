package au.com.mycomp.main;

import com.amazonaws.auth.profile.ProfileCredentialsProvider;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.model.Bucket;

public class PhotoUploader implements ActionListener {

	private ProfileCredentialsProvider crp;
	private AWSCredentials awsCredentials;
	private AmazonS3Client s3;
	private JFrame frame;
	private JButton button;
	private JPanel panel;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PhotoUploader p = new PhotoUploader();
		p.ShowBuckets();
		//

	}

	public PhotoUploader() {

		crp = new ProfileCredentialsProvider("DevApp");
		awsCredentials = crp.getCredentials();
		s3 = new AmazonS3Client(awsCredentials);

	}

	public void ShowBuckets() {
		for (Bucket bucket : s3.listBuckets()) {

			System.out.println(bucket.getName());
			System.out.println();

		}
		frame = new JFrame("hello");
		button = new JButton("hello world");
		panel = new JPanel();
		panel.add(button);
		frame.getContentPane().add(BorderLayout.EAST, panel);
		frame.setSize(200, 200);
		frame.setVisible(true);
	}

	public void actionPerformed(ActionEvent event) {
		button.setText("pressed");
	}

}
