class 4318 extends SkillVisualEffect;

defaultproperties
{
	Begin Object Class=SkillAction_LocateEffect Name=SkillAction_LocateEffect4
		AttachOn=AM_LA
		offset=(X=0.000000,Y=0.000000,Z=-1.000000)
		bSpawnOnTarget=True
		bSizeScale=True
		EffectClass=Class'LineageEffect.mo_battle_roar_ta'
		bOnMultiTarget=True
	End Object
	Desc="궁극의 버프" //Ultimate Buff
	CastingActions=(Action=SkillAction_LocateEffect'SkillAction_LocateEffect4',SpecificStage=0)
}