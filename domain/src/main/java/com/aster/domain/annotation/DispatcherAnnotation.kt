package com.aster.domain.annotation

import javax.inject.Qualifier

/**
 * @author Achmad Ichsan (achmad.ichsan@dana.id)
 * @version DispatcherAnnotation, v 0.1 03/04/22 12.45 by Achmad Ichsan
 */
@Target(
    AnnotationTarget.CLASS,
    AnnotationTarget.TYPE_PARAMETER,
    AnnotationTarget.VALUE_PARAMETER,
    AnnotationTarget.FUNCTION,
    AnnotationTarget.PROPERTY,
)
@Retention
@Qualifier
annotation class DispatcherIO

@Target(
    AnnotationTarget.CLASS,
    AnnotationTarget.TYPE_PARAMETER,
    AnnotationTarget.VALUE_PARAMETER,
    AnnotationTarget.FUNCTION,
    AnnotationTarget.PROPERTY,
)
@Retention
@Qualifier
annotation class DispatcherMain()
