package com.github.eugenelesnov;

import com.intellij.codeInsight.CodeInsightActionHandler;
import com.intellij.codeInsight.generation.OverrideImplementUtil;
import com.intellij.openapi.editor.Editor;
import com.intellij.openapi.project.Project;
import com.intellij.psi.PsiClass;
import com.intellij.psi.PsiFile;
import org.jetbrains.annotations.NotNull;

public class OptionalGetterHandler implements CodeInsightActionHandler {

    @Override
    public boolean startInWriteAction() {
        return true;
    }

    @Override
    public void invoke(@NotNull Project project, @NotNull Editor editor, @NotNull PsiFile file) {
        if (file.isWritable()) {
            PsiClass psiClass = OverrideImplementUtil.getContextClass(project, editor, file, false);
            if (psiClass != null) {

            }
        }
    }
}
