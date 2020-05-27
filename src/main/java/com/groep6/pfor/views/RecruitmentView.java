package com.groep6.pfor.views;

import com.groep6.pfor.util.IObserver;

/**
 * The view where you can choose to recruit legions or barbarians
 * @author Mathijs
 */
public class RecruitmentView implements IObserver {
    /** The recruitmentController */
    private RecruitementController recruitementController;

    /**
     * The constructor
     * @param recruitmentController the recruitmentController
     */
    public RecruitmentView(RecruitmentController recruitmentController) {
        this.recruitmentController = recruitmentController;
    }

    @Override
    public void update() {

    }
}
