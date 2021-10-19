package com.github.eugenelesnov.util;

import com.intellij.openapi.application.ApplicationManager;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.roots.ProjectRootManager;
import com.intellij.psi.JavaPsiFacade;
import com.intellij.psi.PsiClass;
import com.intellij.psi.search.GlobalSearchScope;
import com.intellij.psi.util.CachedValueProvider;
import com.intellij.psi.util.CachedValuesManager;
import org.jetbrains.annotations.NotNull;

public class LibraryUtil {

    public static final String OPTIONAL_GETTER_ANNOTATION_CLASS = "com.github.eugenelesnov.OptionalGetter";

    public static boolean hasLibrary(@NotNull Project project, @NotNull JavaPsiFacade javaPsiFacade) {
        ApplicationManager.getApplication().assertReadAccessAllowed();

        return CachedValuesManager.getManager(project).getCachedValue(project, () -> {
            PsiClass aPackage = javaPsiFacade
                    .findClass(OPTIONAL_GETTER_ANNOTATION_CLASS, GlobalSearchScope.allScope(project));
            return new CachedValueProvider.Result<>(aPackage, ProjectRootManager.getInstance(project));
        }) != null;
    }
}
