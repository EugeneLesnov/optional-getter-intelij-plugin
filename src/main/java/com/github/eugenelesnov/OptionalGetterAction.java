package com.github.eugenelesnov;

import com.github.eugenelesnov.util.LibraryUtil;
import com.intellij.codeInsight.generation.actions.BaseGenerateAction;
import com.intellij.openapi.editor.Editor;
import com.intellij.openapi.project.Project;
import com.intellij.psi.PsiFile;
import org.jetbrains.annotations.NotNull;

public class OptionalGetterAction extends BaseGenerateAction {

    protected OptionalGetterAction() {
        super(new OptionalGetterHandler());
    }

    @Override
    protected boolean isValidForFile(@NotNull Project project, @NotNull Editor editor, @NotNull PsiFile file) {
        return LibraryUtil.hasLibrary(project) && file.isWritable() && super.isValidForFile(project, editor, file);
    }
}
