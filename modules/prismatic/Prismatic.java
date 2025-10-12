package com.vulpuslabs.prismatic;


import voltage.controllers.*;
import voltage.core.*;
import voltage.core.Jack.JackType;
import voltage.sources.*;
import voltage.utility.*;
import voltage.processors.*;
import voltage.effects.*;
import java.awt.*;

//[user-imports]   Add your own imports here
//[/user-imports]


public class Prismatic extends VoltageModule
//[user-inheritance]
//[/user-inheritance]
{

@SuppressWarnings("this-escape") 
public Prismatic( long moduleID, VoltageObjects voltageObjects )
{
   super( moduleID, voltageObjects, "Prismatic", ModuleType.ModuleType_Oscillators, 2.6 );

   InitializeControls();


   canBeBypassed = false;
   SetSkin( "493f76d6471142dab66f7407ed1f1855" );
}

void InitializeControls()
{

   pitchIn = new VoltageAudioJack( "pitchIn", "Pitch In", this, JackType.JackType_AudioInput );
   AddComponent( pitchIn );
   pitchIn.SetWantsMouseNotifications( false );
   pitchIn.SetPosition( 2, 42 );
   pitchIn.SetSize( 25, 25 );
   pitchIn.SetSkin( "Jack Round Marine Blue Ring" );

   monoOscillatorOut = new VoltageAudioJack( "monoOscillatorOut", "Mono Oscillator Out", this, JackType.JackType_AudioOutput );
   AddComponent( monoOscillatorOut );
   monoOscillatorOut.SetWantsMouseNotifications( false );
   monoOscillatorOut.SetPosition( 2, 308 );
   monoOscillatorOut.SetSize( 25, 25 );
   monoOscillatorOut.SetSkin( "Jack Round Mint Ring" );

   fmIn = new VoltageAudioJack( "fmIn", "FM In", this, JackType.JackType_AudioInput );
   AddComponent( fmIn );
   fmIn.SetWantsMouseNotifications( false );
   fmIn.SetPosition( 103, 110 );
   fmIn.SetSize( 25, 25 );
   fmIn.SetSkin( "Jack Round Marine Blue Ring" );

   polyPitchIn = new VoltagePolyJack( "polyPitchIn", "Poly Pitch In", this, JackType.JackType_PolyInput );
   AddComponent( polyPitchIn );
   polyPitchIn.SetWantsMouseNotifications( false );
   polyPitchIn.SetPosition( 58, 42 );
   polyPitchIn.SetSize( 25, 25 );
   polyPitchIn.SetSkin( "Poly Jack Straight" );

   polyOscillatorOut = new VoltagePolyJack( "polyOscillatorOut", "Poly Oscillator Out", this, JackType.JackType_PolyOutput );
   AddComponent( polyOscillatorOut );
   polyOscillatorOut.SetWantsMouseNotifications( false );
   polyOscillatorOut.SetPosition( 58, 309 );
   polyOscillatorOut.SetSize( 25, 25 );
   polyOscillatorOut.SetSkin( "Poly Jack Straight" );

   polyFmIn = new VoltagePolyJack( "polyFmIn", "Poly FM In", this, JackType.JackType_PolyInput );
   AddComponent( polyFmIn );
   polyFmIn.SetWantsMouseNotifications( false );
   polyFmIn.SetPosition( 159, 110 );
   polyFmIn.SetSize( 25, 25 );
   polyFmIn.SetSkin( "Poly Jack Straight" );

   pitch32Toggle = new VoltageToggle( "pitch32Toggle", "-2 Octaves", this, false, 1 );
   AddComponent( pitch32Toggle );
   pitch32Toggle.SetWantsMouseNotifications( false );
   pitch32Toggle.SetPosition( 34, 116 );
   pitch32Toggle.SetSize( 21, 21 );
   pitch32Toggle.SetSkin( "Mini Amber" );
   pitch32Toggle.ShowOverlay( true );
   pitch32Toggle.SetOverlayText( "32" );
   pitch32Toggle.SetOverlayTextFont( "Arial", 12, true, false );
   pitch32Toggle.SetOverlayTextColor( new Color( 0, 0, 0 ) );
   pitch32Toggle.SetOverlayArea( 0, 0, 0, 0 );
   pitch32Toggle.SetOverlayTextJustification( VoltageButton.Justification.Centered );

   pitch16Toggle = new VoltageToggle( "pitch16Toggle", "-1 Octaves", this, false, 1 );
   AddComponent( pitch16Toggle );
   pitch16Toggle.SetWantsMouseNotifications( false );
   pitch16Toggle.SetPosition( 56, 116 );
   pitch16Toggle.SetSize( 21, 21 );
   pitch16Toggle.SetSkin( "Mini Amber" );
   pitch16Toggle.ShowOverlay( true );
   pitch16Toggle.SetOverlayText( "16" );
   pitch16Toggle.SetOverlayTextFont( "Arial", 12, true, false );
   pitch16Toggle.SetOverlayTextColor( new Color( 0, 0, 0 ) );
   pitch16Toggle.SetOverlayArea( 0, 0, 0, 0 );
   pitch16Toggle.SetOverlayTextJustification( VoltageButton.Justification.Centered );

   pitch4Toggle = new VoltageToggle( "pitch4Toggle", "+1 Octaves", this, false, 1 );
   AddComponent( pitch4Toggle );
   pitch4Toggle.SetWantsMouseNotifications( false );
   pitch4Toggle.SetPosition( 34, 138 );
   pitch4Toggle.SetSize( 21, 21 );
   pitch4Toggle.SetSkin( "Mini Amber" );
   pitch4Toggle.ShowOverlay( true );
   pitch4Toggle.SetOverlayText( "4" );
   pitch4Toggle.SetOverlayTextFont( "Arial", 12, true, false );
   pitch4Toggle.SetOverlayTextColor( new Color( 0, 0, 0 ) );
   pitch4Toggle.SetOverlayArea( 0, 0, 0, 0 );
   pitch4Toggle.SetOverlayTextJustification( VoltageButton.Justification.Centered );

   pitch2Toggle = new VoltageToggle( "pitch2Toggle", "+2 Octaves", this, false, 1 );
   AddComponent( pitch2Toggle );
   pitch2Toggle.SetWantsMouseNotifications( false );
   pitch2Toggle.SetPosition( 56, 138 );
   pitch2Toggle.SetSize( 21, 21 );
   pitch2Toggle.SetSkin( "Mini Amber" );
   pitch2Toggle.ShowOverlay( true );
   pitch2Toggle.SetOverlayText( "2" );
   pitch2Toggle.SetOverlayTextFont( "Arial", 12, true, false );
   pitch2Toggle.SetOverlayTextColor( new Color( 0, 0, 0 ) );
   pitch2Toggle.SetOverlayArea( 0, 0, 0, 0 );
   pitch2Toggle.SetOverlayTextJustification( VoltageButton.Justification.Centered );

   semitoneKnob = new VoltageKnob( "semitoneKnob", "Semitone", this, -7, 7, 0 );
   AddComponent( semitoneKnob );
   semitoneKnob.SetWantsMouseNotifications( false );
   semitoneKnob.SetPosition( 103, 36 );
   semitoneKnob.SetSize( 35, 35 );
   semitoneKnob.SetSkin( "Pointer Knob" );
   semitoneKnob.SetRange( -7, 7, 0, false, 15 );
   semitoneKnob.SetKnobParams( 215, 145 );
   semitoneKnob.DisplayValueInPercent( false );
   semitoneKnob.SetKnobAdjustsRing( true );

   centsKnob = new VoltageKnob( "centsKnob", "Cents", this, -100, 100, 0 );
   AddComponent( centsKnob );
   centsKnob.SetWantsMouseNotifications( false );
   centsKnob.SetPosition( 145, 36 );
   centsKnob.SetSize( 35, 35 );
   centsKnob.SetSkin( "Pointer Knob Black" );
   centsKnob.SetRange( -100, 100, 0, false, 201 );
   centsKnob.SetKnobParams( 215, 145 );
   centsKnob.DisplayValueInPercent( false );
   centsKnob.SetKnobAdjustsRing( true );

   textLabel1 = new VoltageLabel( "textLabel1", "textLabel1", this, "OCTAVE" );
   AddComponent( textLabel1 );
   textLabel1.SetWantsMouseNotifications( false );
   textLabel1.SetPosition( 0, 90 );
   textLabel1.SetSize( 86, 15 );
   textLabel1.SetEditable( false, false );
   textLabel1.SetJustificationFlags( VoltageLabel.Justification.HorizCentered );
   textLabel1.SetJustificationFlags( VoltageLabel.Justification.VertCentered );
   textLabel1.SetColor( new Color( 255, 255, 255, 255 ) );
   textLabel1.SetBkColor( new Color( 128, 64, 64, 255 ) );
   textLabel1.SetBorderColor( new Color( 0, 0, 0, 0 ) );
   textLabel1.SetBorderSize( 1 );
   textLabel1.SetMultiLineEdit( false );
   textLabel1.SetIsNumberEditor( false );
   textLabel1.SetNumberEditorRange( 0, 100 );
   textLabel1.SetNumberEditorInterval( 1 );
   textLabel1.SetNumberEditorUsesMouseWheel( false );
   textLabel1.SetHasCustomTextHoverColor( false );
   textLabel1.SetTextHoverColor( new Color( 0, 0, 0, 255 ) );
   textLabel1.SetFont( "Arial", 10, true, false );

   textLabel2 = new VoltageLabel( "textLabel2", "textLabel2", this, "Prismatic" );
   AddComponent( textLabel2 );
   textLabel2.SetWantsMouseNotifications( false );
   textLabel2.SetPosition( 0, 0 );
   textLabel2.SetSize( 86, 15 );
   textLabel2.SetEditable( false, false );
   textLabel2.SetJustificationFlags( VoltageLabel.Justification.HorizCentered );
   textLabel2.SetJustificationFlags( VoltageLabel.Justification.VertCentered );
   textLabel2.SetColor( new Color( 255, 255, 255, 255 ) );
   textLabel2.SetBkColor( new Color( 65, 65, 65, 0 ) );
   textLabel2.SetBorderColor( new Color( 0, 0, 0, 0 ) );
   textLabel2.SetBorderSize( 1 );
   textLabel2.SetMultiLineEdit( false );
   textLabel2.SetIsNumberEditor( false );
   textLabel2.SetNumberEditorRange( 0, 100 );
   textLabel2.SetNumberEditorInterval( 1 );
   textLabel2.SetNumberEditorUsesMouseWheel( false );
   textLabel2.SetHasCustomTextHoverColor( false );
   textLabel2.SetTextHoverColor( new Color( 0, 0, 0, 255 ) );
   textLabel2.SetFont( "Arial", 10, true, false );

   textLabel3 = new VoltageLabel( "textLabel3", "textLabel3", this, "PITCH ADJUST" );
   AddComponent( textLabel3 );
   textLabel3.SetWantsMouseNotifications( false );
   textLabel3.SetPosition( 99, 16 );
   textLabel3.SetSize( 86, 15 );
   textLabel3.SetEditable( false, false );
   textLabel3.SetJustificationFlags( VoltageLabel.Justification.HorizCentered );
   textLabel3.SetJustificationFlags( VoltageLabel.Justification.VertCentered );
   textLabel3.SetColor( new Color( 255, 255, 255, 255 ) );
   textLabel3.SetBkColor( new Color( 128, 64, 64, 255 ) );
   textLabel3.SetBorderColor( new Color( 0, 0, 0, 0 ) );
   textLabel3.SetBorderSize( 1 );
   textLabel3.SetMultiLineEdit( false );
   textLabel3.SetIsNumberEditor( false );
   textLabel3.SetNumberEditorRange( 0, 100 );
   textLabel3.SetNumberEditorInterval( 1 );
   textLabel3.SetNumberEditorUsesMouseWheel( false );
   textLabel3.SetHasCustomTextHoverColor( false );
   textLabel3.SetTextHoverColor( new Color( 0, 0, 0, 255 ) );
   textLabel3.SetFont( "Arial", 10, true, false );

   textLabel5 = new VoltageLabel( "textLabel5", "textLabel5", this, "V/OCT IN" );
   AddComponent( textLabel5 );
   textLabel5.SetWantsMouseNotifications( false );
   textLabel5.SetPosition( 0, 16 );
   textLabel5.SetSize( 86, 15 );
   textLabel5.SetEditable( false, false );
   textLabel5.SetJustificationFlags( VoltageLabel.Justification.HorizCentered );
   textLabel5.SetJustificationFlags( VoltageLabel.Justification.VertCentered );
   textLabel5.SetColor( new Color( 255, 255, 255, 255 ) );
   textLabel5.SetBkColor( new Color( 128, 64, 64, 255 ) );
   textLabel5.SetBorderColor( new Color( 0, 0, 0, 0 ) );
   textLabel5.SetBorderSize( 1 );
   textLabel5.SetMultiLineEdit( false );
   textLabel5.SetIsNumberEditor( false );
   textLabel5.SetNumberEditorRange( 0, 100 );
   textLabel5.SetNumberEditorInterval( 1 );
   textLabel5.SetNumberEditorUsesMouseWheel( false );
   textLabel5.SetHasCustomTextHoverColor( false );
   textLabel5.SetTextHoverColor( new Color( 0, 0, 0, 255 ) );
   textLabel5.SetFont( "Arial", 10, true, false );

   textLabel6 = new VoltageLabel( "textLabel6", "textLabel6", this, "FM" );
   AddComponent( textLabel6 );
   textLabel6.SetWantsMouseNotifications( false );
   textLabel6.SetPosition( 101, 90 );
   textLabel6.SetSize( 86, 15 );
   textLabel6.SetEditable( false, false );
   textLabel6.SetJustificationFlags( VoltageLabel.Justification.HorizCentered );
   textLabel6.SetJustificationFlags( VoltageLabel.Justification.VertCentered );
   textLabel6.SetColor( new Color( 255, 255, 255, 255 ) );
   textLabel6.SetBkColor( new Color( 128, 64, 64, 255 ) );
   textLabel6.SetBorderColor( new Color( 0, 0, 0, 0 ) );
   textLabel6.SetBorderSize( 1 );
   textLabel6.SetMultiLineEdit( false );
   textLabel6.SetIsNumberEditor( false );
   textLabel6.SetNumberEditorRange( 0, 100 );
   textLabel6.SetNumberEditorInterval( 1 );
   textLabel6.SetNumberEditorUsesMouseWheel( false );
   textLabel6.SetHasCustomTextHoverColor( false );
   textLabel6.SetTextHoverColor( new Color( 0, 0, 0, 255 ) );
   textLabel6.SetFont( "Arial", 10, true, false );

   textLabel4 = new VoltageLabel( "textLabel4", "textLabel4", this, "SEMI" );
   AddComponent( textLabel4 );
   textLabel4.SetWantsMouseNotifications( false );
   textLabel4.SetPosition( 99, 72 );
   textLabel4.SetSize( 44, 15 );
   textLabel4.SetEditable( false, false );
   textLabel4.SetJustificationFlags( VoltageLabel.Justification.HorizCentered );
   textLabel4.SetJustificationFlags( VoltageLabel.Justification.VertCentered );
   textLabel4.SetColor( new Color( 255, 255, 255, 255 ) );
   textLabel4.SetBkColor( new Color( 65, 65, 65, 0 ) );
   textLabel4.SetBorderColor( new Color( 0, 0, 0, 0 ) );
   textLabel4.SetBorderSize( 1 );
   textLabel4.SetMultiLineEdit( false );
   textLabel4.SetIsNumberEditor( false );
   textLabel4.SetNumberEditorRange( 0, 100 );
   textLabel4.SetNumberEditorInterval( 1 );
   textLabel4.SetNumberEditorUsesMouseWheel( false );
   textLabel4.SetHasCustomTextHoverColor( false );
   textLabel4.SetTextHoverColor( new Color( 0, 0, 0, 255 ) );
   textLabel4.SetFont( "Arial", 10, false, false );

   textLabel10 = new VoltageLabel( "textLabel10", "textLabel10", this, "LIN" );
   AddComponent( textLabel10 );
   textLabel10.SetWantsMouseNotifications( false );
   textLabel10.SetPosition( 101, 152 );
   textLabel10.SetSize( 28, 15 );
   textLabel10.SetEditable( false, false );
   textLabel10.SetJustificationFlags( VoltageLabel.Justification.HorizCentered );
   textLabel10.SetJustificationFlags( VoltageLabel.Justification.VertCentered );
   textLabel10.SetColor( new Color( 255, 255, 255, 255 ) );
   textLabel10.SetBkColor( new Color( 65, 65, 65, 0 ) );
   textLabel10.SetBorderColor( new Color( 0, 0, 0, 0 ) );
   textLabel10.SetBorderSize( 1 );
   textLabel10.SetMultiLineEdit( false );
   textLabel10.SetIsNumberEditor( false );
   textLabel10.SetNumberEditorRange( 0, 100 );
   textLabel10.SetNumberEditorInterval( 1 );
   textLabel10.SetNumberEditorUsesMouseWheel( false );
   textLabel10.SetHasCustomTextHoverColor( false );
   textLabel10.SetTextHoverColor( new Color( 0, 0, 0, 255 ) );
   textLabel10.SetFont( "Arial", 10, false, false );

   textLabel11 = new VoltageLabel( "textLabel11", "textLabel11", this, "EXP" );
   AddComponent( textLabel11 );
   textLabel11.SetWantsMouseNotifications( false );
   textLabel11.SetPosition( 159, 152 );
   textLabel11.SetSize( 28, 16 );
   textLabel11.SetEditable( false, false );
   textLabel11.SetJustificationFlags( VoltageLabel.Justification.HorizCentered );
   textLabel11.SetJustificationFlags( VoltageLabel.Justification.VertCentered );
   textLabel11.SetColor( new Color( 255, 255, 255, 255 ) );
   textLabel11.SetBkColor( new Color( 65, 65, 65, 0 ) );
   textLabel11.SetBorderColor( new Color( 0, 0, 0, 0 ) );
   textLabel11.SetBorderSize( 1 );
   textLabel11.SetMultiLineEdit( false );
   textLabel11.SetIsNumberEditor( false );
   textLabel11.SetNumberEditorRange( 0, 100 );
   textLabel11.SetNumberEditorInterval( 1 );
   textLabel11.SetNumberEditorUsesMouseWheel( false );
   textLabel11.SetHasCustomTextHoverColor( false );
   textLabel11.SetTextHoverColor( new Color( 0, 0, 0, 255 ) );
   textLabel11.SetFont( "Arial", 10, false, false );

   textLabel12 = new VoltageLabel( "textLabel12", "textLabel12", this, "MONO" );
   AddComponent( textLabel12 );
   textLabel12.SetWantsMouseNotifications( false );
   textLabel12.SetPosition( 101, 136 );
   textLabel12.SetSize( 28, 15 );
   textLabel12.SetEditable( false, false );
   textLabel12.SetJustificationFlags( VoltageLabel.Justification.HorizCentered );
   textLabel12.SetJustificationFlags( VoltageLabel.Justification.VertCentered );
   textLabel12.SetColor( new Color( 255, 255, 255, 255 ) );
   textLabel12.SetBkColor( new Color( 65, 65, 65, 0 ) );
   textLabel12.SetBorderColor( new Color( 0, 0, 0, 0 ) );
   textLabel12.SetBorderSize( 1 );
   textLabel12.SetMultiLineEdit( false );
   textLabel12.SetIsNumberEditor( false );
   textLabel12.SetNumberEditorRange( 0, 100 );
   textLabel12.SetNumberEditorInterval( 1 );
   textLabel12.SetNumberEditorUsesMouseWheel( false );
   textLabel12.SetHasCustomTextHoverColor( false );
   textLabel12.SetTextHoverColor( new Color( 0, 0, 0, 255 ) );
   textLabel12.SetFont( "Arial", 10, false, false );

   textLabel13 = new VoltageLabel( "textLabel13", "textLabel13", this, "POLY" );
   AddComponent( textLabel13 );
   textLabel13.SetWantsMouseNotifications( false );
   textLabel13.SetPosition( 159, 136 );
   textLabel13.SetSize( 28, 15 );
   textLabel13.SetEditable( false, false );
   textLabel13.SetJustificationFlags( VoltageLabel.Justification.HorizCentered );
   textLabel13.SetJustificationFlags( VoltageLabel.Justification.VertCentered );
   textLabel13.SetColor( new Color( 255, 255, 255, 255 ) );
   textLabel13.SetBkColor( new Color( 65, 65, 65, 0 ) );
   textLabel13.SetBorderColor( new Color( 0, 0, 0, 0 ) );
   textLabel13.SetBorderSize( 1 );
   textLabel13.SetMultiLineEdit( false );
   textLabel13.SetIsNumberEditor( false );
   textLabel13.SetNumberEditorRange( 0, 100 );
   textLabel13.SetNumberEditorInterval( 1 );
   textLabel13.SetNumberEditorUsesMouseWheel( false );
   textLabel13.SetHasCustomTextHoverColor( false );
   textLabel13.SetTextHoverColor( new Color( 0, 0, 0, 255 ) );
   textLabel13.SetFont( "Arial", 10, false, false );

   textLabel14 = new VoltageLabel( "textLabel14", "textLabel14", this, "AMT" );
   AddComponent( textLabel14 );
   textLabel14.SetWantsMouseNotifications( false );
   textLabel14.SetPosition( 130, 107 );
   textLabel14.SetSize( 28, 15 );
   textLabel14.SetEditable( false, false );
   textLabel14.SetJustificationFlags( VoltageLabel.Justification.HorizCentered );
   textLabel14.SetJustificationFlags( VoltageLabel.Justification.VertCentered );
   textLabel14.SetColor( new Color( 255, 255, 255, 255 ) );
   textLabel14.SetBkColor( new Color( 65, 65, 65, 0 ) );
   textLabel14.SetBorderColor( new Color( 0, 0, 0, 0 ) );
   textLabel14.SetBorderSize( 1 );
   textLabel14.SetMultiLineEdit( false );
   textLabel14.SetIsNumberEditor( false );
   textLabel14.SetNumberEditorRange( 0, 100 );
   textLabel14.SetNumberEditorInterval( 1 );
   textLabel14.SetNumberEditorUsesMouseWheel( false );
   textLabel14.SetHasCustomTextHoverColor( false );
   textLabel14.SetTextHoverColor( new Color( 0, 0, 0, 255 ) );
   textLabel14.SetFont( "Arial", 10, false, false );

   textLabel15 = new VoltageLabel( "textLabel15", "textLabel15", this, "MONO" );
   AddComponent( textLabel15 );
   textLabel15.SetWantsMouseNotifications( false );
   textLabel15.SetPosition( 0, 65 );
   textLabel15.SetSize( 28, 15 );
   textLabel15.SetEditable( false, false );
   textLabel15.SetJustificationFlags( VoltageLabel.Justification.HorizCentered );
   textLabel15.SetJustificationFlags( VoltageLabel.Justification.VertCentered );
   textLabel15.SetColor( new Color( 255, 255, 255, 255 ) );
   textLabel15.SetBkColor( new Color( 65, 65, 65, 0 ) );
   textLabel15.SetBorderColor( new Color( 0, 0, 0, 0 ) );
   textLabel15.SetBorderSize( 1 );
   textLabel15.SetMultiLineEdit( false );
   textLabel15.SetIsNumberEditor( false );
   textLabel15.SetNumberEditorRange( 0, 100 );
   textLabel15.SetNumberEditorInterval( 1 );
   textLabel15.SetNumberEditorUsesMouseWheel( false );
   textLabel15.SetHasCustomTextHoverColor( false );
   textLabel15.SetTextHoverColor( new Color( 0, 0, 0, 255 ) );
   textLabel15.SetFont( "Arial", 10, false, false );

   textLabel16 = new VoltageLabel( "textLabel16", "textLabel16", this, "POLY" );
   AddComponent( textLabel16 );
   textLabel16.SetWantsMouseNotifications( false );
   textLabel16.SetPosition( 58, 65 );
   textLabel16.SetSize( 28, 15 );
   textLabel16.SetEditable( false, false );
   textLabel16.SetJustificationFlags( VoltageLabel.Justification.HorizCentered );
   textLabel16.SetJustificationFlags( VoltageLabel.Justification.VertCentered );
   textLabel16.SetColor( new Color( 255, 255, 255, 255 ) );
   textLabel16.SetBkColor( new Color( 65, 65, 65, 0 ) );
   textLabel16.SetBorderColor( new Color( 0, 0, 0, 0 ) );
   textLabel16.SetBorderSize( 1 );
   textLabel16.SetMultiLineEdit( false );
   textLabel16.SetIsNumberEditor( false );
   textLabel16.SetNumberEditorRange( 0, 100 );
   textLabel16.SetNumberEditorInterval( 1 );
   textLabel16.SetNumberEditorUsesMouseWheel( false );
   textLabel16.SetHasCustomTextHoverColor( false );
   textLabel16.SetTextHoverColor( new Color( 0, 0, 0, 255 ) );
   textLabel16.SetFont( "Arial", 10, false, false );

   textLabel17 = new VoltageLabel( "textLabel17", "textLabel17", this, "MONO" );
   AddComponent( textLabel17 );
   textLabel17.SetWantsMouseNotifications( false );
   textLabel17.SetPosition( 0, 333 );
   textLabel17.SetSize( 28, 15 );
   textLabel17.SetEditable( false, false );
   textLabel17.SetJustificationFlags( VoltageLabel.Justification.HorizCentered );
   textLabel17.SetJustificationFlags( VoltageLabel.Justification.VertCentered );
   textLabel17.SetColor( new Color( 255, 255, 255, 255 ) );
   textLabel17.SetBkColor( new Color( 65, 65, 65, 0 ) );
   textLabel17.SetBorderColor( new Color( 0, 0, 0, 0 ) );
   textLabel17.SetBorderSize( 1 );
   textLabel17.SetMultiLineEdit( false );
   textLabel17.SetIsNumberEditor( false );
   textLabel17.SetNumberEditorRange( 0, 100 );
   textLabel17.SetNumberEditorInterval( 1 );
   textLabel17.SetNumberEditorUsesMouseWheel( false );
   textLabel17.SetHasCustomTextHoverColor( false );
   textLabel17.SetTextHoverColor( new Color( 0, 0, 0, 255 ) );
   textLabel17.SetFont( "Arial", 10, false, false );

   textLabel18 = new VoltageLabel( "textLabel18", "textLabel18", this, "POLY" );
   AddComponent( textLabel18 );
   textLabel18.SetWantsMouseNotifications( false );
   textLabel18.SetPosition( 58, 333 );
   textLabel18.SetSize( 28, 15 );
   textLabel18.SetEditable( false, false );
   textLabel18.SetJustificationFlags( VoltageLabel.Justification.HorizCentered );
   textLabel18.SetJustificationFlags( VoltageLabel.Justification.VertCentered );
   textLabel18.SetColor( new Color( 255, 255, 255, 255 ) );
   textLabel18.SetBkColor( new Color( 65, 65, 65, 0 ) );
   textLabel18.SetBorderColor( new Color( 0, 0, 0, 0 ) );
   textLabel18.SetBorderSize( 1 );
   textLabel18.SetMultiLineEdit( false );
   textLabel18.SetIsNumberEditor( false );
   textLabel18.SetNumberEditorRange( 0, 100 );
   textLabel18.SetNumberEditorInterval( 1 );
   textLabel18.SetNumberEditorUsesMouseWheel( false );
   textLabel18.SetHasCustomTextHoverColor( false );
   textLabel18.SetTextHoverColor( new Color( 0, 0, 0, 255 ) );
   textLabel18.SetFont( "Arial", 10, false, false );

   textLabel7 = new VoltageLabel( "textLabel7", "textLabel7", this, "CENT" );
   AddComponent( textLabel7 );
   textLabel7.SetWantsMouseNotifications( false );
   textLabel7.SetPosition( 143, 72 );
   textLabel7.SetSize( 44, 15 );
   textLabel7.SetEditable( false, false );
   textLabel7.SetJustificationFlags( VoltageLabel.Justification.HorizCentered );
   textLabel7.SetJustificationFlags( VoltageLabel.Justification.VertCentered );
   textLabel7.SetColor( new Color( 255, 255, 255, 255 ) );
   textLabel7.SetBkColor( new Color( 65, 65, 65, 0 ) );
   textLabel7.SetBorderColor( new Color( 0, 0, 0, 0 ) );
   textLabel7.SetBorderSize( 1 );
   textLabel7.SetMultiLineEdit( false );
   textLabel7.SetIsNumberEditor( false );
   textLabel7.SetNumberEditorRange( 0, 100 );
   textLabel7.SetNumberEditorInterval( 1 );
   textLabel7.SetNumberEditorUsesMouseWheel( false );
   textLabel7.SetHasCustomTextHoverColor( false );
   textLabel7.SetTextHoverColor( new Color( 0, 0, 0, 255 ) );
   textLabel7.SetFont( "Arial", 10, false, false );

   textLabel8 = new VoltageLabel( "textLabel8", "textLabel8", this, "OSC OUT" );
   AddComponent( textLabel8 );
   textLabel8.SetWantsMouseNotifications( false );
   textLabel8.SetPosition( 0, 290 );
   textLabel8.SetSize( 86, 15 );
   textLabel8.SetEditable( false, false );
   textLabel8.SetJustificationFlags( VoltageLabel.Justification.HorizCentered );
   textLabel8.SetJustificationFlags( VoltageLabel.Justification.VertCentered );
   textLabel8.SetColor( new Color( 255, 255, 255, 255 ) );
   textLabel8.SetBkColor( new Color( 128, 64, 64, 255 ) );
   textLabel8.SetBorderColor( new Color( 0, 0, 0, 0 ) );
   textLabel8.SetBorderSize( 1 );
   textLabel8.SetMultiLineEdit( false );
   textLabel8.SetIsNumberEditor( false );
   textLabel8.SetNumberEditorRange( 0, 100 );
   textLabel8.SetNumberEditorInterval( 1 );
   textLabel8.SetNumberEditorUsesMouseWheel( false );
   textLabel8.SetHasCustomTextHoverColor( false );
   textLabel8.SetTextHoverColor( new Color( 0, 0, 0, 255 ) );
   textLabel8.SetFont( "Arial", 10, true, false );

   textLabel9 = new VoltageLabel( "textLabel9", "textLabel9", this, "VULPUS LABS" );
   AddComponent( textLabel9 );
   textLabel9.SetWantsMouseNotifications( false );
   textLabel9.SetPosition( 0, 345 );
   textLabel9.SetSize( 86, 15 );
   textLabel9.SetEditable( false, false );
   textLabel9.SetJustificationFlags( VoltageLabel.Justification.HorizCentered );
   textLabel9.SetJustificationFlags( VoltageLabel.Justification.VertCentered );
   textLabel9.SetColor( new Color( 255, 255, 255, 255 ) );
   textLabel9.SetBkColor( new Color( 65, 65, 65, 0 ) );
   textLabel9.SetBorderColor( new Color( 0, 0, 0, 0 ) );
   textLabel9.SetBorderSize( 1 );
   textLabel9.SetMultiLineEdit( false );
   textLabel9.SetIsNumberEditor( false );
   textLabel9.SetNumberEditorRange( 0, 100 );
   textLabel9.SetNumberEditorInterval( 1 );
   textLabel9.SetNumberEditorUsesMouseWheel( false );
   textLabel9.SetHasCustomTextHoverColor( false );
   textLabel9.SetTextHoverColor( new Color( 0, 0, 0, 255 ) );
   textLabel9.SetFont( "Arial", 8, true, false );

   pitch64Toggle = new VoltageToggle( "pitch64Toggle", "-3 Octaves", this, false, 1 );
   AddComponent( pitch64Toggle );
   pitch64Toggle.SetWantsMouseNotifications( false );
   pitch64Toggle.SetPosition( 12, 116 );
   pitch64Toggle.SetSize( 21, 21 );
   pitch64Toggle.SetSkin( "Mini Amber" );
   pitch64Toggle.ShowOverlay( true );
   pitch64Toggle.SetOverlayText( "LO" );
   pitch64Toggle.SetOverlayTextFont( "Arial", 12, true, false );
   pitch64Toggle.SetOverlayTextColor( new Color( 0, 0, 0 ) );
   pitch64Toggle.SetOverlayArea( 0, 0, 0, 0 );
   pitch64Toggle.SetOverlayTextJustification( VoltageButton.Justification.Centered );

   pitch8Toggle = new VoltageToggle( "pitch8Toggle", "Same Octave", this, true, 1 );
   AddComponent( pitch8Toggle );
   pitch8Toggle.SetWantsMouseNotifications( false );
   pitch8Toggle.SetPosition( 12, 138 );
   pitch8Toggle.SetSize( 21, 21 );
   pitch8Toggle.SetSkin( "Mini Amber" );
   pitch8Toggle.ShowOverlay( true );
   pitch8Toggle.SetOverlayText( "8" );
   pitch8Toggle.SetOverlayTextFont( "Arial", 12, true, false );
   pitch8Toggle.SetOverlayTextColor( new Color( 0, 0, 0 ) );
   pitch8Toggle.SetOverlayArea( 0, 0, 0, 0 );
   pitch8Toggle.SetOverlayTextJustification( VoltageButton.Justification.Centered );

   amtKnob = new VoltageKnob( "amtKnob", "FM Amount", this, 0.0, 1.0, 0 );
   AddComponent( amtKnob );
   amtKnob.SetWantsMouseNotifications( false );
   amtKnob.SetPosition( 130, 123 );
   amtKnob.SetSize( 27, 27 );
   amtKnob.SetSkin( "Cosmo Small" );
   amtKnob.SetRange( 0.0, 1.0, 0, false, 0 );
   amtKnob.SetKnobParams( 215, 145 );
   amtKnob.DisplayValueInPercent( false );
   amtKnob.SetKnobAdjustsRing( true );
   amtKnob.SetMidpointValue( 0.2 );

   fmTypeSwitch = new VoltageSwitch( "fmTypeSwitch", "FM Type", this, 1 );
   AddComponent( fmTypeSwitch );
   fmTypeSwitch.SetWantsMouseNotifications( false );
   fmTypeSwitch.SetPosition( 126, 152 );
   fmTypeSwitch.SetSize( 37, 15 );
   fmTypeSwitch.SetSkin( "Rocker Switch Plastic Orange Hor" );

   leftShapeSwitch = new VoltageSwitch( "leftShapeSwitch", "Left Shape", this, 0 );
   AddComponent( leftShapeSwitch );
   leftShapeSwitch.SetWantsMouseNotifications( false );
   leftShapeSwitch.SetPosition( 4, 191 );
   leftShapeSwitch.SetSize( 39, 15 );
   leftShapeSwitch.SetSkin( "3-State Slide Horizontal" );

   shapeInterpolateKnob = new VoltageKnob( "shapeInterpolateKnob", "Shape Interpolate", this, -1, 1.0, 0 );
   AddComponent( shapeInterpolateKnob );
   shapeInterpolateKnob.SetWantsMouseNotifications( false );
   shapeInterpolateKnob.SetPosition( 53, 187 );
   shapeInterpolateKnob.SetSize( 27, 27 );
   shapeInterpolateKnob.SetSkin( "Plastic White" );
   shapeInterpolateKnob.SetRange( -1, 1.0, 0, false, 0 );
   shapeInterpolateKnob.SetKnobParams( 215, 145 );
   shapeInterpolateKnob.DisplayValueInPercent( false );
   shapeInterpolateKnob.SetKnobAdjustsRing( true );

   monoShapeInterpolateModIn = new VoltageAudioJack( "monoShapeInterpolateModIn", "Mono Shape Interpolate Mod", this, JackType.JackType_AudioInput );
   AddComponent( monoShapeInterpolateModIn );
   monoShapeInterpolateModIn.SetWantsMouseNotifications( false );
   monoShapeInterpolateModIn.SetPosition( 122, 189 );
   monoShapeInterpolateModIn.SetSize( 25, 25 );
   monoShapeInterpolateModIn.SetSkin( "Jack Round Marine Blue Ring" );

   polyShapeInterpolateModIn = new VoltagePolyJack( "polyShapeInterpolateModIn", "Poly Shape Interpolate Mod", this, JackType.JackType_PolyInput );
   AddComponent( polyShapeInterpolateModIn );
   polyShapeInterpolateModIn.SetWantsMouseNotifications( false );
   polyShapeInterpolateModIn.SetPosition( 155, 190 );
   polyShapeInterpolateModIn.SetSize( 25, 25 );
   polyShapeInterpolateModIn.SetSkin( "Poly Jack Straight" );

   shapeInterpolateModAmountKnob = new VoltageKnob( "shapeInterpolateModAmountKnob", "Shape Interpolate Modulation Amount", this, -1, 1, 0 );
   AddComponent( shapeInterpolateModAmountKnob );
   shapeInterpolateModAmountKnob.SetWantsMouseNotifications( false );
   shapeInterpolateModAmountKnob.SetPosition( 89, 188 );
   shapeInterpolateModAmountKnob.SetSize( 25, 25 );
   shapeInterpolateModAmountKnob.SetSkin( "ARP2500 Sm Orange" );
   shapeInterpolateModAmountKnob.SetRange( -1, 1, 0, false, 0 );
   shapeInterpolateModAmountKnob.SetKnobParams( 215, 145 );
   shapeInterpolateModAmountKnob.DisplayValueInPercent( false );
   shapeInterpolateModAmountKnob.SetKnobAdjustsRing( true );
}



//-------------------------------------------------------------------------------
//  public void Initialize()

//  Initialize will get called shortly after your module's constructor runs. You can use it to
//  do any initialization that the auto-generated code doesn't handle.
//-------------------------------------------------------------------------------
@Override
public void Initialize()
{
   //[user-Initialize]   Add your own initialization code here
   polyVoices = GetNumberOfPolyVoices();


   //[/user-Initialize]
}


//-------------------------------------------------------------------------------
//  public void Destroy()

//  Destroy will get called just before your module gets deleted. You can use it to perform any
//  cleanup that's not handled automatically by Java.
//-------------------------------------------------------------------------------
@Override
public void Destroy()
{
   super.Destroy();
   //[user-Destroy]   Add your own module-getting-deleted code here



   //[/user-Destroy]
}


//-------------------------------------------------------------------------------
//  public boolean Notify( VoltageComponent component, ModuleNotifications notification, double doubleValue, long longValue, int x, int y, Object object )

//  Notify will get called when various events occur - control values changing, timers firing, etc.
//-------------------------------------------------------------------------------
@Override
public boolean Notify( VoltageComponent component, ModuleNotifications notification, double doubleValue, long longValue, int x, int y, Object object )
{
   //[user-Notify]   Add your own notification handling code between this line and the notify-close comment
   switch( notification )
   {
      case Knob_Changed:   // doubleValue is the new VoltageKnob value
      {
         if (component == semitoneKnob) semitones = doubleValue;
         if (component == centsKnob) cents = doubleValue;
         if (component == amtKnob) {
            fmAmt = doubleValue;
            linearFmAmt = doubleValue * INV_LOG2;
         }
         if (component == shapeInterpolateKnob) shapeInterpolate = doubleValue;
         if (component == shapeInterpolateModAmountKnob) shapeInterpolateModAmount = doubleValue;
         recalculateAdjustment();
      }
      break;
   
      case Slider_Changed:   // doubleValue is the new slider value
      {
      }
      break;
   
      case Button_Changed:   // doubleValue is the new button/toggle button value
      {
         if (doubleValue == 1.0) {
            if (component == pitch64Toggle) octave = -4;
            if (component == pitch32Toggle) octave = -2;
            if (component == pitch16Toggle) octave = -1;
            if (component == pitch8Toggle) octave = 0;
            if (component == pitch4Toggle) octave = 1;
            if (component == pitch2Toggle) octave = 2;
            recalculateAdjustment();
         }
      }
      break;
   
      case Switch_Changed:   // doubleValue is the new switch value
      {
         if (component == leftShapeSwitch) leftShape = (int) doubleValue;
         if (component == rightShapeSwitch) rightShape = (int) doubleValue;
         if (component == fmTypeSwitch) isExp = doubleValue > 0.0;
      }
      break;
   
      case Jack_Connected:   // longValue is the new cable ID
      {
         if (component == polyOscillatorOut) processPoly = true;
      }
      break;
   
      case Jack_Disconnected:   // All cables have been disconnected from this jack
      {
         if (component == polyOscillatorOut) processPoly = false;
      }
      break;
   
      case GUI_Update_Timer:   // Called every 50ms (by default) if turned on
      {
      }
      break;
   
      case Object_MouseMove:   // called when mouse is over an object that receives mouse notifications. 'object' parameter is a VoltageMouseKeyFlags object.
      {
      }
      break;
   
      case Object_MouseLeave:  // called when mouse leaves an object that receives mouse notifications. 'object' parameter is a VoltageMouseKeyFlags object.
      {
      }
      break;
   
      case Object_LeftButtonDown:   // called when user left-clicks on an object that receives mouse notifications. 'object' parameter is a VoltageMouseKeyFlags object.
      {
      }
      break;
   
      case Object_LeftButtonUp:   // called when user releases left mouse button on an object that receives mouse notifications. 'object' parameter is a VoltageMouseKeyFlags object.
      {
      }
      break;
   
      case Object_RightButtonDown:   // called when user releases right mouse button on an object that receives mouse notifications. 'object' parameter is a VoltageMouseKeyFlags object.
      {
      }
      break;
   
      case Object_RightButtonUp:   // called when user right-clicks on an object that receives mouse notifications
      {
      }
      break;
   
      case Object_LeftButtonDoubleClick: // called when user left-button double-clicks on an object that receives mouse notifications
      {
      }
      break;
   
      // Less common notifications:
   
      case Named_Timer:   // object contains a String with the name of the timer that has fired
      {
      }
      break;
   
      case Canvas_Painting:   // About to paint canvas.  object is a java.awt.Rectangle with painting boundaries
      {
      }
      break;
   
      case Canvas_Painted:   // Canvas painting is complete
      {
      }
      break;
   
      case Control_DragStart:    // A user has started dragging on a control that has been marked as draggable
      {
      }
      break;
   
      case Control_DragOn:       // This control has been dragged over during a drag operation. object contains the dragged object
      {
      }
      break;
   
      case Control_DragOff:      // This control has been dragged over during a drag operation. object contains the dragged object
      {
      }
      break;
   
      case Control_DragEnd:      // A user has ended their drag on a control that has been marked as draggable
      {
      }
      break;
   
      case Label_Changed:        // The text of an editable text control has changed
      {
      }
      break;
   
      case SoundPlayback_Start:   // A sound has begun playback
      {
      }
      break;
   
      case SoundPlayback_End:     // A sound has ended playback
      {
      }
      break;
   
      case Scrollbar_Position:    // longValue is the new scrollbar position
      {
      }
      break;
   
      case PolyVoices_Changed:    // longValue is the new number of poly voices
      {
         polyVoices = (int) longValue;
      }
      break;
   
      case File_Dropped:     // 'object' is a String containing the file path
      {
      }
      break;
   
      case Preset_Loading_Start:   // called when preset loading begins
      {
      }
      break;
   
      case Preset_Loading_Finish:  // called when preset loading finishes
      {
      }
      break;
   
      case Variation_Loading_Start:    // sent when a variation is about to load
      {
      }
      break;
   
      case Variation_Loading_Finish:   // sent when a variation has just finished loading
      {
      }
      break;
   
      case Tempo_Changed:     // doubleValue is the new tempo
      {
      }
      break;
   
      case Randomized:     // called when the module's controls get randomized
      {
      }
      break;
   
      case VariationListChanged:   // sent when a variation gets added, deleted, or renamed, or the variations list gets reordered
      {
      }
      break;
   
      case Key_Press:     // sent when module has keyboard focus and a key is pressed; object is a VoltageKeyPressInfo object
      {
      }
      break;
   
      case Reset:    // sent when the module has been reset to default settings
      {
      }
      break;
   
      case Keyboard_NoteOn:   // sent when a note has been pressed on a VoltageKeyboard object. longValue is the note value ( 0-127 )
      {
      }
      break;
   
      case Keyboard_NoteOff:   // sent when a note has been released on a VoltageKeyboard object. longValue is the note value ( 0-127 )
      {
      }
      break;
   
      case Curve_Changed:   // sent when user has edited a curve's value. 'object' will be a VoltageCurve.CurveChangeNotification object.
      {
      }
      break;
   }



   return false;
   //[/user-Notify]
}


//-------------------------------------------------------------------------------
//  public void ProcessSample()

//  ProcessSample is called once per sample. Usually it's where you read
//  from input jacks, process audio, and write it to your output jacks.
//  Since ProcesssSample gets called 48,000 times per second, offload CPU-intensive operations
//  to other threads when possible and avoid calling native functions.
//-------------------------------------------------------------------------------
@Override
public void ProcessSample()
{
   //[user-ProcessSample]   Add your own process-sampling code here
   double monoFm = fmIn.GetValue();
   double monoPitch = adjustPitch(pitchIn.GetValue(), monoFm);
   double monoShapeInterpolate = shapeInterpolate +
      (shapeInterpolateModAmount * monoShapeInterpolateModIn.GetValue() * 0.2);
   double monoSample = monoOsc.synthesize(leftShape, rightShape, monoShapeInterpolate, monoPitch);
   
   monoOscillatorOut.SetValue(monoSample * 5.0);
   
   /*
   if (processPoly) {
      for (int i =0; i<polyVoices; i++) {
         double polyFm = polyFmIn.GetPolyValue(i);
         polyPitchOut.SetPolyValue(
            i,
            adjustPitch(
               polyPitchIn.GetPolyValue(i),
               polyFm + monoFm));
      }
   }
   */
   //[/user-ProcessSample]
}


//-------------------------------------------------------------------------------
//  public String GetTooltipText( VoltageComponent component )

//  Gets called when a tooltip is about to display for a control. Override it if
//  you want to change what the tooltip displays - if you want a knob to work in logarithmic fashion,
//  for instance, you can translate the knob's current value to a log-based string and display it here.
//-------------------------------------------------------------------------------
@Override
public String GetTooltipText( VoltageComponent component )
{
   //[user-GetTooltipText]   Add your own code here



   return super.GetTooltipText( component );
   //[/user-GetTooltipText]
}


//-------------------------------------------------------------------------------
//  public void EditComponentValue( VoltageComponent component, double newValue, String newText )

//  Gets called after a user clicks on a tooltip and types in a new value for a control. Override this if
//  you've changed the default tooltip display (translating a linear value to logarithmic, for instance)
//  in GetTooltipText().
//-------------------------------------------------------------------------------
@Override
public void EditComponentValue( VoltageComponent component, double newValue, String newText )
{
   //[user-EditComponentValue]   Add your own code here



   //[/user-EditComponentValue]
   super.EditComponentValue( component, newValue, newText );
}


//-------------------------------------------------------------------------------
//  public void OnUndoRedo( String undoType, double newValue, Object optionalObject )

//  If you've created custom undo events via calls to CreateUndoEvent, you'll need to
//  process them in this function when they get triggered by undo/redo actions.
//-------------------------------------------------------------------------------
@Override
public void OnUndoRedo( String undoType, double newValue, Object optionalObject )
{
   //[user-OnUndoRedo]   Add your own code here



   //[/user-OnUndoRedo]
}


//-------------------------------------------------------------------------------
//  public byte[] GetStateInformation()

//  Gets called when the module's state gets saved, typically when the user saves a preset with
//  this module in it. Voltage Modular will automatically save the states of knobs, sliders, etc.,
//  but if you have any custom state information you need to save, return it from this function.
//-------------------------------------------------------------------------------
@Override
public byte[] GetStateInformation()
{
   //[user-GetStateInformation]   Add your own code here



   return null;
   //[/user-GetStateInformation]
}


//-------------------------------------------------------------------------------
//  public void SetStateInformation(byte[] stateInfo)

//  Gets called when this module's state is getting restored, typically when a user opens a preset with
//  this module in it. The stateInfo parameter will contain whatever custom data you stored in GetStateInformation().
//-------------------------------------------------------------------------------
@Override
public void SetStateInformation(byte[] stateInfo)
{
   //[user-SetStateInformation]   Add your own code here



   //[/user-SetStateInformation]
}


//-------------------------------------------------------------------------------
//  public byte[] GetStateInformationForVariations()

//  Gets called when a user saves a variation with this module in it.
//  Voltage Modular will automatically save the states of knobs, sliders, etc.,
//  but if you have any custom state information you need to save, return it from this function.
//-------------------------------------------------------------------------------
@Override
public byte[] GetStateInformationForVariations()
{
   //[user-GetStateInformationForVariations]   Add your own code here



   return GetStateInformation();
   //[/user-GetStateInformationForVariations]
}


//-------------------------------------------------------------------------------
//  public void SetStateInformationForVariations(byte[] stateInfo)

//  Gets called when a user loads a variation with this module in it.
//  The stateInfo parameter will contain whatever custom data you stored in GetStateInformationForVariations().
//-------------------------------------------------------------------------------
@Override
public void SetStateInformationForVariations(byte[] stateInfo)
{
   //[user-SetStateInformationForVariations]   Add your own code here
   SetStateInformation(stateInfo);



   //[/user-SetStateInformationForVariations]
}


// Auto-generated variables
private VoltageKnob shapeInterpolateModAmountKnob;
private VoltagePolyJack polyShapeInterpolateModIn;
private VoltageAudioJack monoShapeInterpolateModIn;
private VoltageKnob shapeInterpolateKnob;
private VoltageSwitch leftShapeSwitch;
private VoltageSwitch fmTypeSwitch;
private VoltageKnob amtKnob;
private VoltageToggle pitch8Toggle;
private VoltageToggle pitch64Toggle;
private VoltageLabel textLabel9;
private VoltageLabel textLabel8;
private VoltageLabel textLabel7;
private VoltageLabel textLabel18;
private VoltageLabel textLabel17;
private VoltageLabel textLabel16;
private VoltageLabel textLabel15;
private VoltageLabel textLabel14;
private VoltageLabel textLabel13;
private VoltageLabel textLabel12;
private VoltageLabel textLabel11;
private VoltageLabel textLabel10;
private VoltageLabel textLabel4;
private VoltageLabel textLabel6;
private VoltageLabel textLabel5;
private VoltageLabel textLabel3;
private VoltageLabel textLabel2;
private VoltageLabel textLabel1;
private VoltageKnob centsKnob;
private VoltageKnob semitoneKnob;
private VoltageToggle pitch2Toggle;
private VoltageToggle pitch4Toggle;
private VoltageToggle pitch16Toggle;
private VoltageToggle pitch32Toggle;
private VoltagePolyJack polyFmIn;
private VoltagePolyJack polyOscillatorOut;
private VoltagePolyJack polyPitchIn;
private VoltageAudioJack fmIn;
private VoltageAudioJack monoOscillatorOut;
private VoltageAudioJack pitchIn;


//[user-code-and-variables]    Add your own variables and functions here
private double octave;
private double semitones;
private double cents;
private double fmAmt;
private double linearFmAmt;
private boolean isExp;
private boolean processPoly;
private int polyVoices;
private static final double SEMITONE = 1.0 / 12.0;
private static final double CENT = 1.0 / 1200.0;
private static final double INV_LOG2 = 1.0 / Math.log(2.0);
private double adjustment;

private int leftShape;
private int rightShape;
private double shapeInterpolate;
private double shapeInterpolateModAmount;

private final PhaseDistortionEngine engine = PhaseDistortionEngine.create();
private Oscillator monoOsc = new Oscillator(engine);
private Oscillator[] polyOsc = makeOscillators(16, engine);

private static Oscillator[] makeOscillators(int count, PhaseDistortionEngine engine) {
   Oscillator[] result = new Oscillator[count];
   for (int i=0; i<count; i++) {
      result[i] = new Oscillator(engine);
   }
   return result;
}

private void recalculateAdjustment() {
   adjustment = octave + (semitones * SEMITONE) + (cents * CENT);
}

private double adjustPitch(double pitch, double fm) {
   pitch += adjustment;
   if (isExp) {
      pitch += fm * fmAmt;
   } else {
      pitch += Math.log(1.0 + Math.abs(fm)) * linearFmAmt * Math.signum(fm);
   }
   return pitch;
}

private static class PhaseDistortionEngine {
    // Waveform profile constants
    public static final int PROFILE_SINE = 0;
    public static final int PROFILE_SAWTOOTH = 1;
    public static final int PROFILE_SQUARE = 2;
    public static final int PROFILE_RESONANT = 3;
    
    // Lookup tables: 256-byte distortion curves
    private final int[][] distortionProfiles;
    
    // Sine wave table: 256 values in range -128 to 127
    private final int[] sineTable;
    
    private PhaseDistortionEngine(int[][] distortionProfiles, int[] sineTable) {
        this.distortionProfiles = distortionProfiles;
        this.sineTable = sineTable;
    }
    
    /**
     * Create a new PhaseDistortionEngine with initialized lookup tables
     */
    public static PhaseDistortionEngine create() {
        int[] sineTable = createSineTable();
        int[][] distortionProfiles = createDistortionProfiles();
        return new PhaseDistortionEngine(distortionProfiles, sineTable);
    }
    
    private static int[] createSineTable() {
        int[] table = new int[256];
        
        // Generate sine wave: values from -128 to 127
        for (int i = 0; i < 256; i++) {
            double angle = (i / 256.0) * 2.0 * Math.PI;
            double sineValue = Math.sin(angle);
            table[i] = (int) Math.round(sineValue * 127);
        }
        
        return table;
    }
    
    private static int[][] createDistortionProfiles() {
        int[][] profiles = new int[4][256];
        
        // Profile 0: Sine (linear/identity - no distortion)
        for (int i = 0; i < 256; i++) {
            profiles[PROFILE_SINE][i] = i;
        }
        
        // Profile 1: Sawtooth
        createSawtoothProfile(profiles[PROFILE_SAWTOOTH]);
        
        // Profile 2: Square/Pulse
        createSquareProfile(profiles[PROFILE_SQUARE]);
        
        // Profile 3: Resonant
        createResonantProfile(profiles[PROFILE_RESONANT]);
        
        return profiles;
    }
    
    private static void createSawtoothProfile(int[] profile) {
      // Slow gradual rise, smooth through top, fast fall
      int[][] breakpoints = {
          {0, 0},       // Start at zero crossing
          {112, 64},    // Rise to peak
          {144, 192},   // Rapid drop through zero to bottom
          {255, 255}    // Fast finish back to zero
      };
        
        buildPiecewiseLinear(profile, breakpoints);
    }
    
    private static void createSquareProfile(int[] profile) {
       // Smooth transitions through zero, hold at peaks
       int[][] breakpoints = {
           {0, 0},       // Start at zero crossing
           {16, 60},     // Rise smoothly to positive peak
           {112, 68},     // Hold near positive peak
           {128, 128},   // Transition smoothly through zero
           {144, 188},   // Down to negative peak
           {240, 196},   // Hold near negative peak
           {255, 255}    // Transition back to zero (wraps to start)
       };
        
        buildPiecewiseLinear(profile, breakpoints);
    }
    
    private static void createResonantProfile(int[] profile) {
    // Sharp resonant peak around one phase region
    int[][] breakpoints = {
        {0, 0},       // Start at zero
        {85, 255},     // Slow start
        {86, 0},     // Quick jump to resonant region
        {170, 255},
        {171, 0},
        {255, 255}    // Complete
    };
        
        buildPiecewiseLinear(profile, breakpoints);
    }
    
    private static void buildPiecewiseLinear(int[] profile, int[][] breakpoints) {
        for (int segment = 0; segment < breakpoints.length - 1; segment++) {
            int x0 = breakpoints[segment][0];
            int y0 = breakpoints[segment][1];
            int x1 = breakpoints[segment + 1][0];
            int y1 = breakpoints[segment + 1][1];
            
            for (int x = x0; x <= x1 && x < 256; x++) {
                if (x1 == x0) {
                    profile[x] = y0;
                } else {
                    // Linear interpolation
                    int y = y0 + ((y1 - y0) * (x - x0)) / (x1 - x0);
                    profile[x] = y;
                }
            }
        }
    }
    
    /**
     * Generate output sample using phase distortion synthesis
     * 
     * @param leftSelector Profile index for left (0-3)
     * @param rightSelector Profile index for right (0-3)
     * @param dcwParameter Morph amount between profiles (0-255)
     * @param phaseAccumulator Current phase position (0-255)
     * @return Output sample value (-128 to 127)
     */
    public int synthesize(int leftSelector, int rightSelector, int dcwParameter, int phaseAccumulator) {
        // Clamp inputs to valid ranges
        int phase = phaseAccumulator & 0xFF;
        int dcw = dcwParameter & 0xFF;
        
        // Get distorted phase from both profiles
        int leftDistorted = distortionProfiles[leftSelector][phase];
        int rightDistorted = distortionProfiles[rightSelector][phase];
        
        // Interpolate between left and right profiles using DCW parameter
        // Fixed-point 8-bit interpolation
        int distortedPhase = (leftDistorted * (255 - dcw) + rightDistorted * dcw) >> 8;
        
        // Look up sine wave value at distorted phase
        return sineTable[distortedPhase & 0xFF];
    }
}

private static final class Oscillator {

   private static final int SAW_SINE_SQUARE = 0;
   private static final int SINE_SAW_SQUARE = 1;
   private static final int RESO = 2;
   
   private static final double VOCT_TO_INCREMENT = (65.40639132514966 / 16000.0) * 65536.0;

   private final PhaseDistortionEngine engine;
   private int phase;
   private int resoPhase;
   private int count;
   private double previous;
   
   public Oscillator(PhaseDistortionEngine engine) {
      this.engine = engine;
   }
   
   // dcw is in range [-1, 1]
   public double synthesize(int mode, double dcw, double vOct) {
      if (count > 0) {
         count--;
         return previous;
      }
      
      // Translate dcw from [-1, 1] to [0, 255]
      int dcwInt = Math.max(
         0,
         Math.min(
            255,
            (int) Math.round((dcw + 1.0) * 127.5)
         )
      );
      
      // Get phase indices (upper 8 bits of 16-bit accumulator)
      int phaseIndex = (phase >> 8) & 0xFF;
      int resoPhaseIndex = (resoPhase >> 8) & 0xFF;
      
      // Synthesize at 16kHz
      int sample = engine.synthesize(left, right, dcwInt, phaseIndex);
      previous = sample / 128.0;  // Convert to roughly [-1, 1] range
      
      // Advance phase
      double increment = VOCT_TO_INCREMENT * Math.pow(2.0, vOct);
      phase = (phase + (int) Math.round(increment)) & 0xFFFF;
      
      // Reset counter for next 3 samples
      count = 2;  // Will return 'previous' for next 2 calls
      
      return previous;
   }
}


//[/user-code-and-variables]
}

 