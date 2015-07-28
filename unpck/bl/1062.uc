class 1062 extends SkillVisualEffect;

defaultproperties
{
	Begin Object Class=SkillAction_LocateEffect Name=SkillAction_LocateEffect2
		AttachOn=AM_LA
		offset=(X=0.000000,Y=0.000000,Z=-1.000000)
		bSizeScale=True
		EffectClass=Class'LineageEffect.bl_berserker_spirit_ca'
	End Object
	Begin Object Class=SkillAction_LocateEffect Name=SkillAction_LocateEffect3
		AttachOn=AM_LA
		bUseCharacterRotation=True
		offset=(X=0.000000,Y=0.000000,Z=1.000000)
		bSpawnOnTarget=True
		EffectClass=Class'LineageEffect.bl_berserker_spirit_ta'
		bOnMultiTarget=True
	End Object
	Desc="버저커 스피릿" //Berserker Spirit
	CastingActions=(Action=SkillAction_LocateEffect'SkillAction_LocateEffect2',SpecificStage=0)
	ShotActions=(Action=SkillAction_LocateEffect'SkillAction_LocateEffect3',SpecificStage=0)
}