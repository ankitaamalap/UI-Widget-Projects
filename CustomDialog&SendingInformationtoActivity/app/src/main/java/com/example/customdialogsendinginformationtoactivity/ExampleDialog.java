package com.example.customdialogsendinginformationtoactivity;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatDialogFragment;

public class ExampleDialog extends AppCompatDialogFragment {

    private EditText editUsername, editPassword;
    private ExampleDialogListener listener;

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        LayoutInflater inflater = getActivity().getLayoutInflater();
        View view = inflater.inflate(R.layout.layout_dialog, null);

        builder.setView(view)
                .setTitle("Login")
                .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                })
                .setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        // getting data
                        String username = editUsername.getText().toString();
                        String password = editPassword.getText().toString();
                        listener.applyTexts(username, password);
                    }
                });
        editUsername = view.findViewById(R.id.editUsername);
        editPassword = view.findViewById(R.id.editPassword);
        return builder.create();
    }

    //creating interface to show given data on activity
    public interface ExampleDialogListener {
        //passing data
        void applyTexts(String username, String password);

    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);

        // for try-catch (ctrl+alt+t)
        try {
            listener = (ExampleDialogListener) context;
        } catch (ClassCastException e) {
            // if we forget to implement ExampleDialogListener in main activity then its throw this error(So we can't even open this dialog)
            throw new ClassCastException(context.toString()
                    + "must implement ExampleDialogListener");
        }
    }
}
