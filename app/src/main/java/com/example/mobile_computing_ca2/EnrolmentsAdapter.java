package com.example.mobile_computing_ca2;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.mobile_computing_ca2.model.Enrolment;

import java.util.List;

class EnrolmentsAdapter extends RecyclerView.Adapter<EnrolmentsAdapter.ViewHolder> {

    public class ViewHolder extends RecyclerView.ViewHolder {

        public final View mView;
        public final TextView mDateView;
        public final TextView mCourseView;
        public final TextView mStudentView;
        public Enrolment mEnrolment;

        public ViewHolder(View view) {
            super(view);
            mView = view;
            mDateView = view.findViewById(R.id.enrolment_item_date);
            mCourseView = view.findViewById(R.id.enrolment_item_course);
            mStudentView = view.findViewById(R.id.enrolment_item_student);
        }

    }

    private final EnrolmentsFragment mFragment;
    private final List<Enrolment> mEnrolments;

    public EnrolmentsAdapter(EnrolmentsFragment enrolmentsFragment, List<Enrolment> enrolments) {
        mFragment = enrolmentsFragment;
        mEnrolments = enrolments;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int type) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.fragment_enrolments_item, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int position) {
        final Enrolment enrolment = mEnrolments.get(position);
        viewHolder.mDateView.setText(enrolment.getDate());
        viewHolder.mCourseView.setText(enrolment.getCourse().getTitle());
        viewHolder.mStudentView.setText(enrolment.getStudent().getName());
        viewHolder.mEnrolment = enrolment;

        viewHolder.mView.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                mFragment.onItemSelected(enrolment);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mEnrolments.size();
    }
}
