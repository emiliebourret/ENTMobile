package com.example.entmobile.schedule;

import android.app.AlertDialog;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.DialogFragment;

import com.example.entmobile.R;

/**
 * Dialog class that show a more detailed version of a course
 * It is accessible by clicking on a course on the Schedule
 */
public class DialogOpenCourse extends DialogFragment {
    AlertDialog.Builder builder;

    public DialogOpenCourse(View view, Course course) {
        ViewGroup viewGroup = view.findViewById(android.R.id.content); // create a new ViewGroup
        View dialogView = LayoutInflater.from(view.getContext()).inflate(R.layout.schedule_dialog_course, viewGroup, false);
        // get the layout for the dialog

        String[] infos = course.getTotalInfos();
        Log.i("prompt", infos.length + "");
        toTextView(dialogView, R.id.start_dialog, infos[0]); // set start hour text
        toTextView(dialogView, R.id.end_dialog, infos[1]); // set end hour text
        toTextView(dialogView, R.id.name_dialog, infos[2]); // set course's name text
        toTextView(dialogView, R.id.room_dialog, infos[3]); // set room text
        toTextView(dialogView, R.id.teacher_dialog, infos[4]); // set teacher text
        toTextView(dialogView, R.id.students_dialog, infos[5]); // set students text
        toTextView(dialogView, R.id.duration_dialog, infos[6]); // set duration text

        buildDialog(dialogView);
    }

    /**
     * Set the value of a text view
     *
     * @param view  View from where to take the context
     * @param id    The id of the resource
     * @param value The value of the text
     */
    private void toTextView(View view, int id, String value) {
        ((TextView) view.findViewById(id)).setText(value);
    }

    /**
     * Set the dialog's builder
     *
     * @param dialogView The view from where to build the Dialog
     */
    private void buildDialog(View dialogView) {
        builder = new AlertDialog.Builder(dialogView.getContext()); // create a dialog builder
        builder.setView(dialogView)
                .setCancelable(true)
                .setTitle(""); // build the dialog with this view
    }

    /**
     * Show the dialog if it has been initialized
     */
    public void show() {
        if (builder != null)
            builder.create().show(); // show the dialog
    }

}