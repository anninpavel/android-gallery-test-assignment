/*
 * MIT License
 *
 * Copyright (c) 2018 Pavel Annin
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

package ru.annin.gallerytestassignment.presentation.gallery;

import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProvider;
import android.support.annotation.NonNull;

import ru.annin.gallerytestassignment.domain.GalleryUseCase;
import ru.annin.gallerytestassignment.presentation.gallery.detail.GalleryDetailViewModel;
import ru.annin.gallerytestassignment.presentation.gallery.list.GalleryListViewModel;

/**
 * @author Pavel Annin.
 */
public class GalleryViewModelFactory implements ViewModelProvider.Factory {

    private final GalleryUseCase userCase;

    GalleryViewModelFactory(@NonNull GalleryUseCase userCase) {
        this.userCase = userCase;
    }

    @SuppressWarnings("unchecked")
    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        if (modelClass.isAssignableFrom(GalleryListViewModel.class)) {
            return (T) new GalleryListViewModel(userCase);
        } else if(modelClass.isAssignableFrom(GalleryDetailViewModel.class)) {
            return (T) new GalleryDetailViewModel(userCase);
        } else {
            throw new IllegalArgumentException(String.format("Unknown view model class: %s", modelClass.getName()));
        }
    }
}
