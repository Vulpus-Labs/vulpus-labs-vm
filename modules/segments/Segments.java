package com.vulpuslabs.segments;


import voltage.controllers.*;
import voltage.core.*;
import voltage.core.Jack.JackType;
import voltage.sources.*;
import voltage.utility.*;
import voltage.processors.*;
import voltage.effects.*;
import java.awt.*;

//[user-imports]   Add your own imports here
import com.vulpuslabs.vulpes.modules.segments.*;
import com.vulpuslabs.vulpes.values.events.*;
import com.vulpuslabs.vulpes.values.inputs.*;


//[/user-imports]


public class Segments extends VoltageModule
//[user-inheritance]
//[/user-inheritance]
{

   public Segments( long moduleID, VoltageObjects voltageObjects )
   {
      super( moduleID, voltageObjects, "Segments", ModuleType.ModuleType_Utility, 1.6 );

      InitializeControls();


      canBeBypassed = false;
      SetSkin( "9000f47b54924c47bfa9e23e83534789" );
   }

void InitializeControls()
{

      triggerIn = new VoltageAudioJack( "triggerIn", "Trigger In", this, JackType.JackType_AudioInput );
      AddComponent( triggerIn );
      triggerIn.SetWantsMouseNotifications( false );
      triggerIn.SetPosition( 8, 37 );
      triggerIn.SetSize( 25, 25 );
      triggerIn.SetSkin( "Jack Round Cream Ring" );

      cvOut = new VoltageAudioJack( "cvOut", "CV Out", this, JackType.JackType_AudioOutput );
      AddComponent( cvOut );
      cvOut.SetWantsMouseNotifications( false );
      cvOut.SetPosition( 82, 300 );
      cvOut.SetSize( 25, 25 );
      cvOut.SetSkin( "Jack Round Orange Ring" );

      endTriggerOut = new VoltageAudioJack( "endTriggerOut", "End Trigger Out", this, JackType.JackType_AudioOutput );
      AddComponent( endTriggerOut );
      endTriggerOut.SetWantsMouseNotifications( false );
      endTriggerOut.SetPosition( 82, 37 );
      endTriggerOut.SetSize( 25, 25 );
      endTriggerOut.SetSkin( "Jack Round Orange Ring" );

      gateOut = new VoltageAudioJack( "gateOut", "Gate Out", this, JackType.JackType_AudioOutput );
      AddComponent( gateOut );
      gateOut.SetWantsMouseNotifications( false );
      gateOut.SetPosition( 82, 250 );
      gateOut.SetSize( 25, 25 );
      gateOut.SetSkin( "Jack Round Orange Ring" );

      textLabel1 = new VoltageLabel( "textLabel1", "textLabel1", this, "VULPUS LABS" );
      AddComponent( textLabel1 );
      textLabel1.SetWantsMouseNotifications( false );
      textLabel1.SetPosition( 0, 345 );
      textLabel1.SetSize( 115, 15 );
      textLabel1.SetEditable( false, false );
      textLabel1.SetJustificationFlags( VoltageLabel.Justification.HorizCentered );
      textLabel1.SetJustificationFlags( VoltageLabel.Justification.VertCentered );
      textLabel1.SetColor( new Color( 255, 255, 255, 255 ) );
      textLabel1.SetBkColor( new Color( 65, 65, 65, 0 ) );
      textLabel1.SetBorderColor( new Color( 0, 0, 0, 0 ) );
      textLabel1.SetBorderSize( 1 );
      textLabel1.SetMultiLineEdit( true );
      textLabel1.SetIsNumberEditor( false );
      textLabel1.SetNumberEditorRange( 0, 100 );
      textLabel1.SetNumberEditorInterval( 1 );
      textLabel1.SetNumberEditorUsesMouseWheel( false );
      textLabel1.SetHasCustomTextHoverColor( false );
      textLabel1.SetTextHoverColor( new Color( 0, 0, 0, 255 ) );
      textLabel1.SetFont( "Arial", 10, true, false );

      textLabel2 = new VoltageLabel( "textLabel2", "textLabel2", this, "SEGMENTS" );
      AddComponent( textLabel2 );
      textLabel2.SetWantsMouseNotifications( false );
      textLabel2.SetPosition( 0, 0 );
      textLabel2.SetSize( 115, 15 );
      textLabel2.SetEditable( false, false );
      textLabel2.SetJustificationFlags( VoltageLabel.Justification.HorizCentered );
      textLabel2.SetJustificationFlags( VoltageLabel.Justification.VertCentered );
      textLabel2.SetColor( new Color( 255, 255, 255, 255 ) );
      textLabel2.SetBkColor( new Color( 65, 65, 65, 0 ) );
      textLabel2.SetBorderColor( new Color( 0, 0, 0, 0 ) );
      textLabel2.SetBorderSize( 1 );
      textLabel2.SetMultiLineEdit( true );
      textLabel2.SetIsNumberEditor( false );
      textLabel2.SetNumberEditorRange( 0, 100 );
      textLabel2.SetNumberEditorInterval( 1 );
      textLabel2.SetNumberEditorUsesMouseWheel( false );
      textLabel2.SetHasCustomTextHoverColor( false );
      textLabel2.SetTextHoverColor( new Color( 0, 0, 0, 255 ) );
      textLabel2.SetFont( "Arial", 10, true, false );

      segmentEndCvIn = new VoltageAudioJack( "segmentEndCvIn", "Segment End CV In", this, JackType.JackType_AudioInput );
      AddComponent( segmentEndCvIn );
      segmentEndCvIn.SetWantsMouseNotifications( false );
      segmentEndCvIn.SetPosition( 8, 137 );
      segmentEndCvIn.SetSize( 25, 25 );
      segmentEndCvIn.SetSkin( "Jack Round Cream Ring" );

      segmentLengthCvIn = new VoltageAudioJack( "segmentLengthCvIn", "Segment Length CV In", this, JackType.JackType_AudioInput );
      AddComponent( segmentLengthCvIn );
      segmentLengthCvIn.SetWantsMouseNotifications( false );
      segmentLengthCvIn.SetPosition( 8, 187 );
      segmentLengthCvIn.SetSize( 25, 25 );
      segmentLengthCvIn.SetSkin( "Jack Round Cream Ring" );

      segmentStartCvIn = new VoltageAudioJack( "segmentStartCvIn", "Segment Start CV", this, JackType.JackType_AudioInput );
      AddComponent( segmentStartCvIn );
      segmentStartCvIn.SetWantsMouseNotifications( false );
      segmentStartCvIn.SetPosition( 8, 87 );
      segmentStartCvIn.SetSize( 25, 25 );
      segmentStartCvIn.SetSkin( "Jack Round Cream Ring" );

      segmentStart = new VoltageKnob( "segmentStart", "Segment Start", this, -5, 5, 0 );
      AddComponent( segmentStart );
      segmentStart.SetWantsMouseNotifications( false );
      segmentStart.SetPosition( 45, 87 );
      segmentStart.SetSize( 27, 27 );
      segmentStart.SetSkin( "Plastic Cream" );
      segmentStart.SetRange( -5, 5, 0, false, 0 );
      segmentStart.SetKnobParams( 215, 145 );
      segmentStart.SetUnits( "v" );
      segmentStart.DisplayValueInPercent( false );
      segmentStart.SetKnobAdjustsRing( true );

      segmentLength = new VoltageKnob( "segmentLength", "Segment Length", this, -5, 5, 0.0 );
      AddComponent( segmentLength );
      segmentLength.SetWantsMouseNotifications( false );
      segmentLength.SetPosition( 45, 187 );
      segmentLength.SetSize( 27, 27 );
      segmentLength.SetSkin( "Plastic Cream" );
      segmentLength.SetRange( -5, 5, 0.0, false, 0 );
      segmentLength.SetKnobParams( 215, 145 );
      segmentLength.DisplayValueInPercent( false );
      segmentLength.SetKnobAdjustsRing( true );

      segmentEnd = new VoltageKnob( "segmentEnd", "Segment End", this, -5, 5, 0 );
      AddComponent( segmentEnd );
      segmentEnd.SetWantsMouseNotifications( false );
      segmentEnd.SetPosition( 45, 137 );
      segmentEnd.SetSize( 27, 27 );
      segmentEnd.SetSkin( "Plastic Cream" );
      segmentEnd.SetRange( -5, 5, 0, false, 0 );
      segmentEnd.SetKnobParams( 215, 145 );
      segmentEnd.SetUnits( "v" );
      segmentEnd.DisplayValueInPercent( false );
      segmentEnd.SetKnobAdjustsRing( true );

      textLabel3 = new VoltageLabel( "textLabel3", "textLabel3", this, "START" );
      AddComponent( textLabel3 );
      textLabel3.SetWantsMouseNotifications( false );
      textLabel3.SetPosition( 3, 17 );
      textLabel3.SetSize( 35, 15 );
      textLabel3.SetEditable( false, false );
      textLabel3.SetJustificationFlags( VoltageLabel.Justification.HorizCentered );
      textLabel3.SetJustificationFlags( VoltageLabel.Justification.VertCentered );
      textLabel3.SetColor( new Color( 0, 0, 0, 255 ) );
      textLabel3.SetBkColor( new Color( 176, 176, 144, 255 ) );
      textLabel3.SetBorderColor( new Color( 0, 0, 0, 0 ) );
      textLabel3.SetBorderSize( 1 );
      textLabel3.SetMultiLineEdit( true );
      textLabel3.SetIsNumberEditor( false );
      textLabel3.SetNumberEditorRange( 0, 100 );
      textLabel3.SetNumberEditorInterval( 1 );
      textLabel3.SetNumberEditorUsesMouseWheel( false );
      textLabel3.SetHasCustomTextHoverColor( false );
      textLabel3.SetTextHoverColor( new Color( 0, 0, 0, 255 ) );
      textLabel3.SetFont( "Arial", 10, true, false );

      textLabel4 = new VoltageLabel( "textLabel4", "textLabel4", this, "IN" );
      AddComponent( textLabel4 );
      textLabel4.SetWantsMouseNotifications( false );
      textLabel4.SetPosition( 3, 67 );
      textLabel4.SetSize( 35, 15 );
      textLabel4.SetEditable( false, false );
      textLabel4.SetJustificationFlags( VoltageLabel.Justification.HorizCentered );
      textLabel4.SetJustificationFlags( VoltageLabel.Justification.VertCentered );
      textLabel4.SetColor( new Color( 0, 0, 0, 255 ) );
      textLabel4.SetBkColor( new Color( 176, 176, 144, 255 ) );
      textLabel4.SetBorderColor( new Color( 0, 0, 0, 0 ) );
      textLabel4.SetBorderSize( 1 );
      textLabel4.SetMultiLineEdit( true );
      textLabel4.SetIsNumberEditor( false );
      textLabel4.SetNumberEditorRange( 0, 100 );
      textLabel4.SetNumberEditorInterval( 1 );
      textLabel4.SetNumberEditorUsesMouseWheel( false );
      textLabel4.SetHasCustomTextHoverColor( false );
      textLabel4.SetTextHoverColor( new Color( 0, 0, 0, 255 ) );
      textLabel4.SetFont( "Arial", 10, true, false );

      textLabel5 = new VoltageLabel( "textLabel5", "textLabel5", this, "IN" );
      AddComponent( textLabel5 );
      textLabel5.SetWantsMouseNotifications( false );
      textLabel5.SetPosition( 3, 117 );
      textLabel5.SetSize( 35, 15 );
      textLabel5.SetEditable( false, false );
      textLabel5.SetJustificationFlags( VoltageLabel.Justification.HorizCentered );
      textLabel5.SetJustificationFlags( VoltageLabel.Justification.VertCentered );
      textLabel5.SetColor( new Color( 0, 0, 0, 255 ) );
      textLabel5.SetBkColor( new Color( 176, 176, 144, 255 ) );
      textLabel5.SetBorderColor( new Color( 0, 0, 0, 0 ) );
      textLabel5.SetBorderSize( 1 );
      textLabel5.SetMultiLineEdit( true );
      textLabel5.SetIsNumberEditor( false );
      textLabel5.SetNumberEditorRange( 0, 100 );
      textLabel5.SetNumberEditorInterval( 1 );
      textLabel5.SetNumberEditorUsesMouseWheel( false );
      textLabel5.SetHasCustomTextHoverColor( false );
      textLabel5.SetTextHoverColor( new Color( 0, 0, 0, 255 ) );
      textLabel5.SetFont( "Arial", 10, true, false );

      textLabel6 = new VoltageLabel( "textLabel6", "textLabel6", this, "IN" );
      AddComponent( textLabel6 );
      textLabel6.SetWantsMouseNotifications( false );
      textLabel6.SetPosition( 3, 167 );
      textLabel6.SetSize( 35, 15 );
      textLabel6.SetEditable( false, false );
      textLabel6.SetJustificationFlags( VoltageLabel.Justification.HorizCentered );
      textLabel6.SetJustificationFlags( VoltageLabel.Justification.VertCentered );
      textLabel6.SetColor( new Color( 0, 0, 0, 255 ) );
      textLabel6.SetBkColor( new Color( 176, 176, 144, 255 ) );
      textLabel6.SetBorderColor( new Color( 0, 0, 0, 0 ) );
      textLabel6.SetBorderSize( 1 );
      textLabel6.SetMultiLineEdit( true );
      textLabel6.SetIsNumberEditor( false );
      textLabel6.SetNumberEditorRange( 0, 100 );
      textLabel6.SetNumberEditorInterval( 1 );
      textLabel6.SetNumberEditorUsesMouseWheel( false );
      textLabel6.SetHasCustomTextHoverColor( false );
      textLabel6.SetTextHoverColor( new Color( 0, 0, 0, 255 ) );
      textLabel6.SetFont( "Arial", 10, true, false );

      textLabel7 = new VoltageLabel( "textLabel7", "textLabel7", this, "LINK" );
      AddComponent( textLabel7 );
      textLabel7.SetWantsMouseNotifications( false );
      textLabel7.SetPosition( 3, 280 );
      textLabel7.SetSize( 35, 15 );
      textLabel7.SetEditable( false, false );
      textLabel7.SetJustificationFlags( VoltageLabel.Justification.HorizCentered );
      textLabel7.SetJustificationFlags( VoltageLabel.Justification.VertCentered );
      textLabel7.SetColor( new Color( 0, 0, 0, 255 ) );
      textLabel7.SetBkColor( new Color( 176, 176, 144, 255 ) );
      textLabel7.SetBorderColor( new Color( 0, 0, 0, 0 ) );
      textLabel7.SetBorderSize( 1 );
      textLabel7.SetMultiLineEdit( true );
      textLabel7.SetIsNumberEditor( false );
      textLabel7.SetNumberEditorRange( 0, 100 );
      textLabel7.SetNumberEditorInterval( 1 );
      textLabel7.SetNumberEditorUsesMouseWheel( false );
      textLabel7.SetHasCustomTextHoverColor( false );
      textLabel7.SetTextHoverColor( new Color( 0, 0, 0, 255 ) );
      textLabel7.SetFont( "Arial", 10, true, false );

      textLabel8 = new VoltageLabel( "textLabel8", "textLabel8", this, "LINK" );
      AddComponent( textLabel8 );
      textLabel8.SetWantsMouseNotifications( false );
      textLabel8.SetPosition( 3, 230 );
      textLabel8.SetSize( 35, 15 );
      textLabel8.SetEditable( false, false );
      textLabel8.SetJustificationFlags( VoltageLabel.Justification.HorizCentered );
      textLabel8.SetJustificationFlags( VoltageLabel.Justification.VertCentered );
      textLabel8.SetColor( new Color( 0, 0, 0, 255 ) );
      textLabel8.SetBkColor( new Color( 176, 176, 144, 255 ) );
      textLabel8.SetBorderColor( new Color( 0, 0, 0, 0 ) );
      textLabel8.SetBorderSize( 1 );
      textLabel8.SetMultiLineEdit( true );
      textLabel8.SetIsNumberEditor( false );
      textLabel8.SetNumberEditorRange( 0, 100 );
      textLabel8.SetNumberEditorInterval( 1 );
      textLabel8.SetNumberEditorUsesMouseWheel( false );
      textLabel8.SetHasCustomTextHoverColor( false );
      textLabel8.SetTextHoverColor( new Color( 0, 0, 0, 255 ) );
      textLabel8.SetFont( "Arial", 10, true, false );

      gateLength = new VoltageKnob( "gateLength", "Gate Length", this, 0.0, 1.0, 1 );
      AddComponent( gateLength );
      gateLength.SetWantsMouseNotifications( false );
      gateLength.SetPosition( 45, 250 );
      gateLength.SetSize( 27, 27 );
      gateLength.SetSkin( "Plastic Cream" );
      gateLength.SetRange( 0.0, 1.0, 1, false, 0 );
      gateLength.SetKnobParams( 215, 145 );
      gateLength.DisplayValueInPercent( true );
      gateLength.SetKnobAdjustsRing( true );

      rangeSwitch = new VoltageSwitch( "rangeSwitch", "Range Switch", this, 0 );
      AddComponent( rangeSwitch );
      rangeSwitch.SetWantsMouseNotifications( false );
      rangeSwitch.SetPosition( 40, 213 );
      rangeSwitch.SetSize( 35, 15 );
      rangeSwitch.SetSkin( "5-State Slide Horizontal" );

      textLabel9 = new VoltageLabel( "textLabel9", "textLabel9", this, "10ms" );
      AddComponent( textLabel9 );
      textLabel9.SetWantsMouseNotifications( false );
      textLabel9.SetPosition( 5, 212 );
      textLabel9.SetSize( 33, 15 );
      textLabel9.SetEditable( false, false );
      textLabel9.SetJustificationFlags( VoltageLabel.Justification.Right );
      textLabel9.SetJustificationFlags( VoltageLabel.Justification.VertCentered );
      textLabel9.SetColor( new Color( 255, 255, 255, 255 ) );
      textLabel9.SetBkColor( new Color( 65, 65, 65, 0 ) );
      textLabel9.SetBorderColor( new Color( 0, 0, 0, 0 ) );
      textLabel9.SetBorderSize( 1 );
      textLabel9.SetMultiLineEdit( true );
      textLabel9.SetIsNumberEditor( false );
      textLabel9.SetNumberEditorRange( 0, 100 );
      textLabel9.SetNumberEditorInterval( 1 );
      textLabel9.SetNumberEditorUsesMouseWheel( false );
      textLabel9.SetHasCustomTextHoverColor( false );
      textLabel9.SetTextHoverColor( new Color( 0, 0, 0, 255 ) );
      textLabel9.SetFont( "Arial", 10, true, false );

      textLabel23 = new VoltageLabel( "textLabel23", "textLabel23", this, "S&H" );
      AddComponent( textLabel23 );
      textLabel23.SetWantsMouseNotifications( false );
      textLabel23.SetPosition( 3, 329 );
      textLabel23.SetSize( 35, 15 );
      textLabel23.SetEditable( false, false );
      textLabel23.SetJustificationFlags( VoltageLabel.Justification.Right );
      textLabel23.SetJustificationFlags( VoltageLabel.Justification.VertCentered );
      textLabel23.SetColor( new Color( 255, 255, 255, 255 ) );
      textLabel23.SetBkColor( new Color( 65, 65, 65, 0 ) );
      textLabel23.SetBorderColor( new Color( 0, 0, 0, 0 ) );
      textLabel23.SetBorderSize( 1 );
      textLabel23.SetMultiLineEdit( true );
      textLabel23.SetIsNumberEditor( false );
      textLabel23.SetNumberEditorRange( 0, 100 );
      textLabel23.SetNumberEditorInterval( 1 );
      textLabel23.SetNumberEditorUsesMouseWheel( false );
      textLabel23.SetHasCustomTextHoverColor( false );
      textLabel23.SetTextHoverColor( new Color( 0, 0, 0, 255 ) );
      textLabel23.SetFont( "Arial", 10, true, false );

      textLabel10 = new VoltageLabel( "textLabel10", "textLabel10", this, "10s" );
      AddComponent( textLabel10 );
      textLabel10.SetWantsMouseNotifications( false );
      textLabel10.SetPosition( 79, 212 );
      textLabel10.SetSize( 33, 15 );
      textLabel10.SetEditable( false, false );
      textLabel10.SetJustificationFlags( VoltageLabel.Justification.Left );
      textLabel10.SetJustificationFlags( VoltageLabel.Justification.VertCentered );
      textLabel10.SetColor( new Color( 255, 255, 255, 255 ) );
      textLabel10.SetBkColor( new Color( 65, 65, 65, 0 ) );
      textLabel10.SetBorderColor( new Color( 0, 0, 0, 0 ) );
      textLabel10.SetBorderSize( 1 );
      textLabel10.SetMultiLineEdit( true );
      textLabel10.SetIsNumberEditor( false );
      textLabel10.SetNumberEditorRange( 0, 100 );
      textLabel10.SetNumberEditorInterval( 1 );
      textLabel10.SetNumberEditorUsesMouseWheel( false );
      textLabel10.SetHasCustomTextHoverColor( false );
      textLabel10.SetTextHoverColor( new Color( 0, 0, 0, 255 ) );
      textLabel10.SetFont( "Arial", 10, true, false );

      textLabel24 = new VoltageLabel( "textLabel24", "textLabel24", this, "CONT" );
      AddComponent( textLabel24 );
      textLabel24.SetWantsMouseNotifications( false );
      textLabel24.SetPosition( 77, 329 );
      textLabel24.SetSize( 35, 15 );
      textLabel24.SetEditable( false, false );
      textLabel24.SetJustificationFlags( VoltageLabel.Justification.Left );
      textLabel24.SetJustificationFlags( VoltageLabel.Justification.VertCentered );
      textLabel24.SetColor( new Color( 255, 255, 255, 255 ) );
      textLabel24.SetBkColor( new Color( 65, 65, 65, 0 ) );
      textLabel24.SetBorderColor( new Color( 0, 0, 0, 0 ) );
      textLabel24.SetBorderSize( 1 );
      textLabel24.SetMultiLineEdit( true );
      textLabel24.SetIsNumberEditor( false );
      textLabel24.SetNumberEditorRange( 0, 100 );
      textLabel24.SetNumberEditorInterval( 1 );
      textLabel24.SetNumberEditorUsesMouseWheel( false );
      textLabel24.SetHasCustomTextHoverColor( false );
      textLabel24.SetTextHoverColor( new Color( 0, 0, 0, 255 ) );
      textLabel24.SetFont( "Arial", 10, true, false );

      manualTriggerButton = new VoltageButton( "manualTriggerButton", "Manual Trigger", this );
      AddComponent( manualTriggerButton );
      manualTriggerButton.SetWantsMouseNotifications( false );
      manualTriggerButton.SetPosition( 45, 38 );
      manualTriggerButton.SetSize( 23, 23 );
      manualTriggerButton.SetSkin( "2500 Round Red" );
      manualTriggerButton.ShowOverlay( false );
      manualTriggerButton.SetOverlayText( "" );
      manualTriggerButton.SetAutoRepeat( false );

      segmentStartCvOut = new VoltageAudioJack( "segmentStartCvOut", "Segment Start CV Out", this, JackType.JackType_AudioOutput );
      AddComponent( segmentStartCvOut );
      segmentStartCvOut.SetWantsMouseNotifications( false );
      segmentStartCvOut.SetPosition( 82, 87 );
      segmentStartCvOut.SetSize( 25, 25 );
      segmentStartCvOut.SetSkin( "Jack Round Orange Ring" );

      segmentEndCvOut = new VoltageAudioJack( "segmentEndCvOut", "Segment End CV Out", this, JackType.JackType_AudioOutput );
      AddComponent( segmentEndCvOut );
      segmentEndCvOut.SetWantsMouseNotifications( false );
      segmentEndCvOut.SetPosition( 82, 137 );
      segmentEndCvOut.SetSize( 25, 25 );
      segmentEndCvOut.SetSkin( "Jack Round Orange Ring" );

      segmentLengthCvOut = new VoltageAudioJack( "segmentLengthCvOut", "Segment Length CV Out", this, JackType.JackType_AudioOutput );
      AddComponent( segmentLengthCvOut );
      segmentLengthCvOut.SetWantsMouseNotifications( false );
      segmentLengthCvOut.SetPosition( 82, 187 );
      segmentLengthCvOut.SetSize( 25, 25 );
      segmentLengthCvOut.SetSkin( "Jack Round Orange Ring" );

      gateIn = new VoltageAudioJack( "gateIn", "Gate In", this, JackType.JackType_AudioInput );
      AddComponent( gateIn );
      gateIn.SetWantsMouseNotifications( false );
      gateIn.SetPosition( 8, 250 );
      gateIn.SetSize( 25, 25 );
      gateIn.SetSkin( "Jack Round Cream Ring" );

      cvIn = new VoltageAudioJack( "cvIn", "CV In", this, JackType.JackType_AudioInput );
      AddComponent( cvIn );
      cvIn.SetWantsMouseNotifications( false );
      cvIn.SetPosition( 8, 300 );
      cvIn.SetSize( 25, 25 );
      cvIn.SetSkin( "Jack Round Cream Ring" );

      curveTypeKnob = new VoltageKnob( "curveTypeKnob", "Curve Type", this, 0.0, 3, 0 );
      AddComponent( curveTypeKnob );
      curveTypeKnob.SetWantsMouseNotifications( false );
      curveTypeKnob.SetPosition( 45, 301 );
      curveTypeKnob.SetSize( 25, 25 );
      curveTypeKnob.SetSkin( "Dial Cream" );
      curveTypeKnob.SetRange( 0.0, 3, 0, false, 4 );
      curveTypeKnob.SetKnobParams( 215, 145 );
      curveTypeKnob.DisplayValueInPercent( false );
      curveTypeKnob.SetKnobAdjustsRing( true );

      textLabel11 = new VoltageLabel( "textLabel11", "textLabel11", this, "TRIG" );
      AddComponent( textLabel11 );
      textLabel11.SetWantsMouseNotifications( false );
      textLabel11.SetPosition( 40, 17 );
      textLabel11.SetSize( 35, 15 );
      textLabel11.SetEditable( false, false );
      textLabel11.SetJustificationFlags( VoltageLabel.Justification.HorizCentered );
      textLabel11.SetJustificationFlags( VoltageLabel.Justification.VertCentered );
      textLabel11.SetColor( new Color( 0, 0, 0, 255 ) );
      textLabel11.SetBkColor( new Color( 208, 208, 144, 255 ) );
      textLabel11.SetBorderColor( new Color( 0, 0, 0, 0 ) );
      textLabel11.SetBorderSize( 1 );
      textLabel11.SetMultiLineEdit( true );
      textLabel11.SetIsNumberEditor( false );
      textLabel11.SetNumberEditorRange( 0, 100 );
      textLabel11.SetNumberEditorInterval( 1 );
      textLabel11.SetNumberEditorUsesMouseWheel( false );
      textLabel11.SetHasCustomTextHoverColor( false );
      textLabel11.SetTextHoverColor( new Color( 0, 0, 0, 255 ) );
      textLabel11.SetFont( "Arial", 10, true, false );

      textLabel12 = new VoltageLabel( "textLabel12", "textLabel12", this, "START" );
      AddComponent( textLabel12 );
      textLabel12.SetWantsMouseNotifications( false );
      textLabel12.SetPosition( 40, 67 );
      textLabel12.SetSize( 35, 15 );
      textLabel12.SetEditable( false, false );
      textLabel12.SetJustificationFlags( VoltageLabel.Justification.HorizCentered );
      textLabel12.SetJustificationFlags( VoltageLabel.Justification.VertCentered );
      textLabel12.SetColor( new Color( 0, 0, 0, 255 ) );
      textLabel12.SetBkColor( new Color( 208, 208, 144, 255 ) );
      textLabel12.SetBorderColor( new Color( 0, 0, 0, 0 ) );
      textLabel12.SetBorderSize( 1 );
      textLabel12.SetMultiLineEdit( true );
      textLabel12.SetIsNumberEditor( false );
      textLabel12.SetNumberEditorRange( 0, 100 );
      textLabel12.SetNumberEditorInterval( 1 );
      textLabel12.SetNumberEditorUsesMouseWheel( false );
      textLabel12.SetHasCustomTextHoverColor( false );
      textLabel12.SetTextHoverColor( new Color( 0, 0, 0, 255 ) );
      textLabel12.SetFont( "Arial", 10, true, false );

      textLabel13 = new VoltageLabel( "textLabel13", "textLabel13", this, "END" );
      AddComponent( textLabel13 );
      textLabel13.SetWantsMouseNotifications( false );
      textLabel13.SetPosition( 40, 117 );
      textLabel13.SetSize( 35, 15 );
      textLabel13.SetEditable( false, false );
      textLabel13.SetJustificationFlags( VoltageLabel.Justification.HorizCentered );
      textLabel13.SetJustificationFlags( VoltageLabel.Justification.VertCentered );
      textLabel13.SetColor( new Color( 0, 0, 0, 255 ) );
      textLabel13.SetBkColor( new Color( 208, 208, 144, 255 ) );
      textLabel13.SetBorderColor( new Color( 0, 0, 0, 0 ) );
      textLabel13.SetBorderSize( 1 );
      textLabel13.SetMultiLineEdit( true );
      textLabel13.SetIsNumberEditor( false );
      textLabel13.SetNumberEditorRange( 0, 100 );
      textLabel13.SetNumberEditorInterval( 1 );
      textLabel13.SetNumberEditorUsesMouseWheel( false );
      textLabel13.SetHasCustomTextHoverColor( false );
      textLabel13.SetTextHoverColor( new Color( 0, 0, 0, 255 ) );
      textLabel13.SetFont( "Arial", 10, true, false );

      textLabel14 = new VoltageLabel( "textLabel14", "textLabel14", this, "LEN" );
      AddComponent( textLabel14 );
      textLabel14.SetWantsMouseNotifications( false );
      textLabel14.SetPosition( 40, 167 );
      textLabel14.SetSize( 35, 15 );
      textLabel14.SetEditable( false, false );
      textLabel14.SetJustificationFlags( VoltageLabel.Justification.HorizCentered );
      textLabel14.SetJustificationFlags( VoltageLabel.Justification.VertCentered );
      textLabel14.SetColor( new Color( 0, 0, 0, 255 ) );
      textLabel14.SetBkColor( new Color( 208, 208, 144, 255 ) );
      textLabel14.SetBorderColor( new Color( 0, 0, 0, 0 ) );
      textLabel14.SetBorderSize( 1 );
      textLabel14.SetMultiLineEdit( true );
      textLabel14.SetIsNumberEditor( false );
      textLabel14.SetNumberEditorRange( 0, 100 );
      textLabel14.SetNumberEditorInterval( 1 );
      textLabel14.SetNumberEditorUsesMouseWheel( false );
      textLabel14.SetHasCustomTextHoverColor( false );
      textLabel14.SetTextHoverColor( new Color( 0, 0, 0, 255 ) );
      textLabel14.SetFont( "Arial", 10, true, false );

      textLabel15 = new VoltageLabel( "textLabel15", "textLabel15", this, "CV" );
      AddComponent( textLabel15 );
      textLabel15.SetWantsMouseNotifications( false );
      textLabel15.SetPosition( 40, 280 );
      textLabel15.SetSize( 35, 15 );
      textLabel15.SetEditable( false, false );
      textLabel15.SetJustificationFlags( VoltageLabel.Justification.HorizCentered );
      textLabel15.SetJustificationFlags( VoltageLabel.Justification.VertCentered );
      textLabel15.SetColor( new Color( 0, 0, 0, 255 ) );
      textLabel15.SetBkColor( new Color( 208, 208, 144, 255 ) );
      textLabel15.SetBorderColor( new Color( 0, 0, 0, 0 ) );
      textLabel15.SetBorderSize( 1 );
      textLabel15.SetMultiLineEdit( true );
      textLabel15.SetIsNumberEditor( false );
      textLabel15.SetNumberEditorRange( 0, 100 );
      textLabel15.SetNumberEditorInterval( 1 );
      textLabel15.SetNumberEditorUsesMouseWheel( false );
      textLabel15.SetHasCustomTextHoverColor( false );
      textLabel15.SetTextHoverColor( new Color( 0, 0, 0, 255 ) );
      textLabel15.SetFont( "Arial", 10, true, false );

      textLabel16 = new VoltageLabel( "textLabel16", "textLabel16", this, "GATE" );
      AddComponent( textLabel16 );
      textLabel16.SetWantsMouseNotifications( false );
      textLabel16.SetPosition( 40, 230 );
      textLabel16.SetSize( 35, 15 );
      textLabel16.SetEditable( false, false );
      textLabel16.SetJustificationFlags( VoltageLabel.Justification.HorizCentered );
      textLabel16.SetJustificationFlags( VoltageLabel.Justification.VertCentered );
      textLabel16.SetColor( new Color( 0, 0, 0, 255 ) );
      textLabel16.SetBkColor( new Color( 208, 208, 144, 255 ) );
      textLabel16.SetBorderColor( new Color( 0, 0, 0, 0 ) );
      textLabel16.SetBorderSize( 1 );
      textLabel16.SetMultiLineEdit( true );
      textLabel16.SetIsNumberEditor( false );
      textLabel16.SetNumberEditorRange( 0, 100 );
      textLabel16.SetNumberEditorInterval( 1 );
      textLabel16.SetNumberEditorUsesMouseWheel( false );
      textLabel16.SetHasCustomTextHoverColor( false );
      textLabel16.SetTextHoverColor( new Color( 0, 0, 0, 255 ) );
      textLabel16.SetFont( "Arial", 10, true, false );

      textLabel17 = new VoltageLabel( "textLabel17", "textLabel17", this, "END" );
      AddComponent( textLabel17 );
      textLabel17.SetWantsMouseNotifications( false );
      textLabel17.SetPosition( 77, 17 );
      textLabel17.SetSize( 35, 15 );
      textLabel17.SetEditable( false, false );
      textLabel17.SetJustificationFlags( VoltageLabel.Justification.HorizCentered );
      textLabel17.SetJustificationFlags( VoltageLabel.Justification.VertCentered );
      textLabel17.SetColor( new Color( 0, 0, 0, 255 ) );
      textLabel17.SetBkColor( new Color( 176, 176, 144, 255 ) );
      textLabel17.SetBorderColor( new Color( 0, 0, 0, 0 ) );
      textLabel17.SetBorderSize( 1 );
      textLabel17.SetMultiLineEdit( true );
      textLabel17.SetIsNumberEditor( false );
      textLabel17.SetNumberEditorRange( 0, 100 );
      textLabel17.SetNumberEditorInterval( 1 );
      textLabel17.SetNumberEditorUsesMouseWheel( false );
      textLabel17.SetHasCustomTextHoverColor( false );
      textLabel17.SetTextHoverColor( new Color( 0, 0, 0, 255 ) );
      textLabel17.SetFont( "Arial", 10, true, false );

      textLabel18 = new VoltageLabel( "textLabel18", "textLabel18", this, "OUT" );
      AddComponent( textLabel18 );
      textLabel18.SetWantsMouseNotifications( false );
      textLabel18.SetPosition( 77, 67 );
      textLabel18.SetSize( 35, 15 );
      textLabel18.SetEditable( false, false );
      textLabel18.SetJustificationFlags( VoltageLabel.Justification.HorizCentered );
      textLabel18.SetJustificationFlags( VoltageLabel.Justification.VertCentered );
      textLabel18.SetColor( new Color( 0, 0, 0, 255 ) );
      textLabel18.SetBkColor( new Color( 176, 176, 144, 255 ) );
      textLabel18.SetBorderColor( new Color( 0, 0, 0, 0 ) );
      textLabel18.SetBorderSize( 1 );
      textLabel18.SetMultiLineEdit( true );
      textLabel18.SetIsNumberEditor( false );
      textLabel18.SetNumberEditorRange( 0, 100 );
      textLabel18.SetNumberEditorInterval( 1 );
      textLabel18.SetNumberEditorUsesMouseWheel( false );
      textLabel18.SetHasCustomTextHoverColor( false );
      textLabel18.SetTextHoverColor( new Color( 0, 0, 0, 255 ) );
      textLabel18.SetFont( "Arial", 10, true, false );

      textLabel19 = new VoltageLabel( "textLabel19", "textLabel19", this, "OUT" );
      AddComponent( textLabel19 );
      textLabel19.SetWantsMouseNotifications( false );
      textLabel19.SetPosition( 77, 117 );
      textLabel19.SetSize( 35, 15 );
      textLabel19.SetEditable( false, false );
      textLabel19.SetJustificationFlags( VoltageLabel.Justification.HorizCentered );
      textLabel19.SetJustificationFlags( VoltageLabel.Justification.VertCentered );
      textLabel19.SetColor( new Color( 0, 0, 0, 255 ) );
      textLabel19.SetBkColor( new Color( 176, 176, 144, 255 ) );
      textLabel19.SetBorderColor( new Color( 0, 0, 0, 0 ) );
      textLabel19.SetBorderSize( 1 );
      textLabel19.SetMultiLineEdit( true );
      textLabel19.SetIsNumberEditor( false );
      textLabel19.SetNumberEditorRange( 0, 100 );
      textLabel19.SetNumberEditorInterval( 1 );
      textLabel19.SetNumberEditorUsesMouseWheel( false );
      textLabel19.SetHasCustomTextHoverColor( false );
      textLabel19.SetTextHoverColor( new Color( 0, 0, 0, 255 ) );
      textLabel19.SetFont( "Arial", 10, true, false );

      textLabel20 = new VoltageLabel( "textLabel20", "textLabel20", this, "OUT" );
      AddComponent( textLabel20 );
      textLabel20.SetWantsMouseNotifications( false );
      textLabel20.SetPosition( 77, 167 );
      textLabel20.SetSize( 35, 15 );
      textLabel20.SetEditable( false, false );
      textLabel20.SetJustificationFlags( VoltageLabel.Justification.HorizCentered );
      textLabel20.SetJustificationFlags( VoltageLabel.Justification.VertCentered );
      textLabel20.SetColor( new Color( 0, 0, 0, 255 ) );
      textLabel20.SetBkColor( new Color( 176, 176, 144, 255 ) );
      textLabel20.SetBorderColor( new Color( 0, 0, 0, 0 ) );
      textLabel20.SetBorderSize( 1 );
      textLabel20.SetMultiLineEdit( true );
      textLabel20.SetIsNumberEditor( false );
      textLabel20.SetNumberEditorRange( 0, 100 );
      textLabel20.SetNumberEditorInterval( 1 );
      textLabel20.SetNumberEditorUsesMouseWheel( false );
      textLabel20.SetHasCustomTextHoverColor( false );
      textLabel20.SetTextHoverColor( new Color( 0, 0, 0, 255 ) );
      textLabel20.SetFont( "Arial", 10, true, false );

      textLabel21 = new VoltageLabel( "textLabel21", "textLabel21", this, "OUT" );
      AddComponent( textLabel21 );
      textLabel21.SetWantsMouseNotifications( false );
      textLabel21.SetPosition( 77, 280 );
      textLabel21.SetSize( 35, 15 );
      textLabel21.SetEditable( false, false );
      textLabel21.SetJustificationFlags( VoltageLabel.Justification.HorizCentered );
      textLabel21.SetJustificationFlags( VoltageLabel.Justification.VertCentered );
      textLabel21.SetColor( new Color( 0, 0, 0, 255 ) );
      textLabel21.SetBkColor( new Color( 176, 176, 144, 255 ) );
      textLabel21.SetBorderColor( new Color( 0, 0, 0, 0 ) );
      textLabel21.SetBorderSize( 1 );
      textLabel21.SetMultiLineEdit( true );
      textLabel21.SetIsNumberEditor( false );
      textLabel21.SetNumberEditorRange( 0, 100 );
      textLabel21.SetNumberEditorInterval( 1 );
      textLabel21.SetNumberEditorUsesMouseWheel( false );
      textLabel21.SetHasCustomTextHoverColor( false );
      textLabel21.SetTextHoverColor( new Color( 0, 0, 0, 255 ) );
      textLabel21.SetFont( "Arial", 10, true, false );

      textLabel22 = new VoltageLabel( "textLabel22", "textLabel22", this, "OUT" );
      AddComponent( textLabel22 );
      textLabel22.SetWantsMouseNotifications( false );
      textLabel22.SetPosition( 77, 230 );
      textLabel22.SetSize( 35, 15 );
      textLabel22.SetEditable( false, false );
      textLabel22.SetJustificationFlags( VoltageLabel.Justification.HorizCentered );
      textLabel22.SetJustificationFlags( VoltageLabel.Justification.VertCentered );
      textLabel22.SetColor( new Color( 0, 0, 0, 255 ) );
      textLabel22.SetBkColor( new Color( 176, 176, 144, 255 ) );
      textLabel22.SetBorderColor( new Color( 0, 0, 0, 0 ) );
      textLabel22.SetBorderSize( 1 );
      textLabel22.SetMultiLineEdit( true );
      textLabel22.SetIsNumberEditor( false );
      textLabel22.SetNumberEditorRange( 0, 100 );
      textLabel22.SetNumberEditorInterval( 1 );
      textLabel22.SetNumberEditorUsesMouseWheel( false );
      textLabel22.SetHasCustomTextHoverColor( false );
      textLabel22.SetTextHoverColor( new Color( 0, 0, 0, 255 ) );
      textLabel22.SetFont( "Arial", 10, true, false );

      segmentActiveLed = new VoltageLED( "segmentActiveLed", "Segment Active", this );
      AddComponent( segmentActiveLed );
      segmentActiveLed.SetWantsMouseNotifications( false );
      segmentActiveLed.SetPosition( 70, 35 );
      segmentActiveLed.SetSize( 11, 11 );
      segmentActiveLed.SetSkin( "Green" );

      modeSwitch = new VoltageSwitch( "modeSwitch", "Mode Switch", this, 1 );
      AddComponent( modeSwitch );
      modeSwitch.SetWantsMouseNotifications( false );
      modeSwitch.SetPosition( 40, 329 );
      modeSwitch.SetSize( 35, 14 );
      modeSwitch.SetSkin( "Rocker Switch Plastic Cream Hor" );
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
      var cvTrigger = new TriggerInput(triggerIn::GetValue);
      receiver.register(triggerIn, cvTrigger::setIsConnected);
      
      receiver.register(manualTriggerButton, manualTrigger::setValue);
      
      var trigger = new BooleanOr(cvTrigger, manualTrigger);
         
      var startIn = new InputOrKnob(receiver.registerInput(segmentStartCvIn, segmentStartCvIn::GetValue));
      receiver.registerKnob(segmentStart, segmentStart.GetValue(), startIn::setKnobValue);
      
      var endIn = new InputOrKnob(receiver.registerInput(segmentEndCvIn, segmentEndCvIn::GetValue));
      receiver.registerKnob(segmentEnd, segmentEnd.GetValue(), endIn::setKnobValue);
      
      var lengthIn = new InputOrKnob(receiver.registerInput(segmentLengthCvIn, segmentLengthCvIn::GetValue));
      receiver.registerKnob(segmentLength, segmentLength.GetValue(), lengthIn::setKnobValue);
      
      inputBus = new InputBus(trigger, startIn, endIn, lengthIn,
            receiver.registerInput(gateIn, gateIn::GetValue),
            receiver.registerInput(cvIn, cvIn::GetValue));
            
      receiver.register(rangeSwitch, inputBus::setLengthRange);
      receiver.register(gateLength, inputBus::setGateLengthPercent);
      
      curve = new Curve();
      receiver.register(curveTypeKnob, curve::setCurveType);
      
      outputBus = new OutputBus(
         endTriggerOut::SetValue,
         segmentStartCvOut::SetValue,
         segmentEndCvOut::SetValue,
         segmentLengthCvOut::SetValue,
         gateOut::SetValue,
         cvOut::SetValue);
         
      controller = new Controller(inputBus, outputBus, curve);
      
      receiver.register(modeSwitch, controller::setContinuousMode);
      StartGuiUpdateTimer();
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
         case Knob_Changed: return receiver.knobValueChanged(component, doubleValue);
      
         case Slider_Changed:   // doubleValue is the new slider value
         {
         }
         break;
      
         case Button_Changed: return receiver.buttonChanged(component, doubleValue);
      
         case Switch_Changed: return receiver.switchChanged(component, doubleValue);
      
         case Jack_Connected: return receiver.jackConnected(component);
      
         case Jack_Disconnected: return receiver.jackDisconnected(component);
      
         case GUI_Update_Timer:   // Called every 50ms (by default) if turned on
         {
            segmentActiveLed.SetValue(curve.isRunning() ? 1.0 : 0.0);
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
      controller.processSample();
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
      if (component == segmentLength) {
         return inputBus.getLengthKnobValueDescription(segmentLength.GetValue());
      }
      
      if (component == rangeSwitch) {
         return inputBus.getRangeDescription();
      }
      
      if (component == curveTypeKnob) {
         return curve.getSelectedCurveName();
      }
      
      if (component == modeSwitch) {
         return modeSwitch.GetValue() == 0.0
            ? "Sample and hold"
            : "Continuous";
      }

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
   private VoltageSwitch modeSwitch;
   private VoltageLED segmentActiveLed;
   private VoltageLabel textLabel22;
   private VoltageLabel textLabel21;
   private VoltageLabel textLabel20;
   private VoltageLabel textLabel19;
   private VoltageLabel textLabel18;
   private VoltageLabel textLabel17;
   private VoltageLabel textLabel16;
   private VoltageLabel textLabel15;
   private VoltageLabel textLabel14;
   private VoltageLabel textLabel13;
   private VoltageLabel textLabel12;
   private VoltageLabel textLabel11;
   private VoltageKnob curveTypeKnob;
   private VoltageAudioJack cvIn;
   private VoltageAudioJack gateIn;
   private VoltageAudioJack segmentLengthCvOut;
   private VoltageAudioJack segmentEndCvOut;
   private VoltageAudioJack segmentStartCvOut;
   private VoltageButton manualTriggerButton;
   private VoltageLabel textLabel24;
   private VoltageLabel textLabel10;
   private VoltageLabel textLabel23;
   private VoltageLabel textLabel9;
   private VoltageSwitch rangeSwitch;
   private VoltageKnob gateLength;
   private VoltageLabel textLabel8;
   private VoltageLabel textLabel7;
   private VoltageLabel textLabel6;
   private VoltageLabel textLabel5;
   private VoltageLabel textLabel4;
   private VoltageLabel textLabel3;
   private VoltageKnob segmentEnd;
   private VoltageKnob segmentLength;
   private VoltageKnob segmentStart;
   private VoltageAudioJack segmentStartCvIn;
   private VoltageAudioJack segmentLengthCvIn;
   private VoltageAudioJack segmentEndCvIn;
   private VoltageLabel textLabel2;
   private VoltageLabel textLabel1;
   private VoltageAudioJack gateOut;
   private VoltageAudioJack endTriggerOut;
   private VoltageAudioJack cvOut;
   private VoltageAudioJack triggerIn;


   //[user-code-and-variables]    Add your own variables and functions here

private InputBus inputBus;
private OutputBus outputBus;
private Curve curve;
private Controller controller;
private final ManualTrigger manualTrigger = new ManualTrigger();

private final NotificationReceiver receiver = new NotificationReceiver();




   //[/user-code-and-variables]
}

 